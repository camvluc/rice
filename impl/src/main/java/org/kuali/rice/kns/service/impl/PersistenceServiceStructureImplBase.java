/*
 * Copyright 2006 The Kuali Foundation.
 *
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl1.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.rice.kns.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.ojb.broker.metadata.ClassDescriptor;
import org.apache.ojb.broker.metadata.ClassNotPersistenceCapableException;
import org.apache.ojb.broker.metadata.DescriptorRepository;
import org.apache.ojb.broker.metadata.FieldDescriptor;
import org.apache.ojb.broker.metadata.ObjectReferenceDescriptor;
import org.kuali.rice.core.jpa.metadata.EntityDescriptor;
import org.kuali.rice.core.jpa.metadata.MetadataManager;
import org.kuali.rice.core.jpa.metadata.ObjectDescriptor;
import org.kuali.rice.core.util.OrmUtils;
import org.kuali.rice.kns.bo.PersistableBusinessObject;
import org.kuali.rice.kns.exception.ClassNotPersistableException;
import org.kuali.rice.kns.exception.ObjectNotABusinessObjectRuntimeException;
import org.kuali.rice.kns.util.spring.CacheNoCopy;

public class PersistenceServiceStructureImplBase {

	private DescriptorRepository descriptorRepository;

	// This is repeated in BaseOjbConfigurer
	private static final String OJB_PROPERTIES_PROP = "OJB.properties";

	private static final String DEFAULT_OJB_PROPERTIES = "org/kuali/rice/core/ojb/RiceOJB.properties";

	/**
	 * Constructs a PersistenceServiceImpl instance.
	 */
	public PersistenceServiceStructureImplBase() {
		String currentValue = System.getProperty(OJB_PROPERTIES_PROP);
		System.setProperty(OJB_PROPERTIES_PROP, DEFAULT_OJB_PROPERTIES);
		try {
			org.apache.ojb.broker.metadata.MetadataManager metadataManager = org.apache.ojb.broker.metadata.MetadataManager.getInstance();
			descriptorRepository = metadataManager.getGlobalRepository();
		} finally {
			if (currentValue == null) {
				System.getProperties().remove(OJB_PROPERTIES_PROP);
			} else {
				System.setProperty(OJB_PROPERTIES_PROP, currentValue);
			}
		}
	}

	/**
	 * @return DescriptorRepository containing everything OJB knows about persistable classes
	 */
	protected DescriptorRepository getDescriptorRepository() {
		return descriptorRepository;
	}

	/**
	 *
	 * This method returns a list of primary key field names.  This method uses the CacheNoCopy caching method.
	 * "NoCopy" is the faster of the caching annotations, but because it does not make a copy the list that is
	 * returned must not be modified.  To enforce this the returned list is wrapped in a Collections.unmodifiableList
	 * method.  This will cause an exception to be thrown if the list is altered.
	 *
	 * @param clazz
	 * @return unmodifiableList of field names.  Any attempt to alter list will result in an UnsupportedOperationException
	 */
	@CacheNoCopy
	public List listPrimaryKeyFieldNames(Class clazz) {
    	// Rice JPA MetadataManager
		if (OrmUtils.isJpaAnnotated(clazz) && OrmUtils.isJpaEnabled()) {
			List fieldNames = new ArrayList();
	    	EntityDescriptor descriptor = MetadataManager.getEntityDescriptor(clazz);
	    	for (org.kuali.rice.core.jpa.metadata.FieldDescriptor field : descriptor.getPrimaryKeys()) {
	    		fieldNames.add(field.getName());
	    	}
	    	return Collections.unmodifiableList(fieldNames);
		} else {
	    	// Legacy OJB
			List fieldNamesLegacy = new ArrayList();
			ClassDescriptor classDescriptor = getClassDescriptor(clazz);
			FieldDescriptor keyDescriptors[] = classDescriptor.getPkFields();

			for (int i = 0; i < keyDescriptors.length; ++i) {
				FieldDescriptor keyDescriptor = keyDescriptors[i];
				fieldNamesLegacy.add(keyDescriptor.getAttributeName());
			}
			return Collections.unmodifiableList(fieldNamesLegacy);
		}
	}

	/* Not used anywhere... need to check KFS and batch stuff */
	/**
	 * @param classDescriptor
	 * @return name of the database table associated with given classDescriptor,
	 *         stripped of its leading schemaName
	 */
	/*
	@CacheNoCopy
	protected String getTableName(ClassDescriptor classDescriptor) {
		String schemaName = classDescriptor.getSchema();
		String fullTableName = classDescriptor.getFullTableName();

		String tableName = null;
		if (StringUtils.isNotBlank(schemaName)) {
			tableName = StringUtils.substringAfter(fullTableName, schemaName + ".");
		}
		if (StringUtils.isBlank(tableName)) {
			tableName = fullTableName;
		}

		return tableName;
	}
	*/

	/**
	 * @param persistableClass
	 * @return ClassDescriptor for the given Class
	 * @throws IllegalArgumentException
	 *             if the given Class is null
	 * @throws ClassNotPersistableException
	 *             if the given Class is unknown to OJB
	 */
	// Legacy OJB - no need for JPA equivalent
	@CacheNoCopy
	protected ClassDescriptor getClassDescriptor(Class persistableClass) {
		if (persistableClass == null) {
			throw new IllegalArgumentException("invalid (null) object");
		}

		ClassDescriptor classDescriptor = null;
		DescriptorRepository globalRepository = getDescriptorRepository();
		try {
			classDescriptor = globalRepository.getDescriptorFor(persistableClass);
		} catch (ClassNotPersistenceCapableException e) {
			throw new ClassNotPersistableException("class '" + persistableClass.getName() + "' is not persistable", e);
		}

		return classDescriptor;
	}

	/**
	 * @see org.kuali.rice.kns.service.PersistenceStructureService#getBusinessObjectAttributeClass(java.lang.Class,
	 *      java.lang.String)
	 */
	@CacheNoCopy
	public Class getBusinessObjectAttributeClass(Class clazz, String attributeName) throws ObjectNotABusinessObjectRuntimeException {
		if (clazz.isAssignableFrom(PersistableBusinessObject.class)) {
			throw new ObjectNotABusinessObjectRuntimeException(clazz.getName() + " is not a PersistableBusinessObject");
		}
		String baseAttributeName = attributeName;
		String subAttributeString = null;
		if (attributeName.contains(".")) {
			baseAttributeName = attributeName.substring(0, attributeName.indexOf('.'));
			subAttributeString = attributeName.substring(attributeName.indexOf('.') + 1);
		}

    	// Rice JPA MetadataManager
		if (OrmUtils.isJpaAnnotated(clazz) && OrmUtils.isJpaEnabled()) {
			Class attributeClass = null;
	    	EntityDescriptor descriptor = MetadataManager.getEntityDescriptor(clazz);
	    	ObjectDescriptor objectDescriptor = descriptor.getObjectDescriptorByName(baseAttributeName);
			if (objectDescriptor != null) {
				attributeClass = objectDescriptor.getTargetEntity();
			}

			// recurse if necessary
			if (subAttributeString != null) {
				attributeClass = getBusinessObjectAttributeClass(attributeClass, subAttributeString);
			}

			return attributeClass;
		} else {
	    	// Legacy OJB
			Class attributeClassLegacy = null;
			ClassDescriptor classDescriptor = this.getClassDescriptor(clazz);
			ObjectReferenceDescriptor refDescriptor = classDescriptor.getObjectReferenceDescriptorByName(baseAttributeName);

			if (refDescriptor != null) {
				attributeClassLegacy = refDescriptor.getItemClass();
			}

			// recurse if necessary
			if (subAttributeString != null) {
				attributeClassLegacy = getBusinessObjectAttributeClass(attributeClassLegacy, subAttributeString);
			}

			return attributeClassLegacy;
		}
	}

}
