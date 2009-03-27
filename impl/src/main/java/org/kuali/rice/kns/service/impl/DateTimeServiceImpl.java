/*
 * Copyright 2005-2007 The Kuali Foundation.
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

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.kuali.rice.kns.service.DateTimeService;
import org.kuali.rice.kns.service.KNSServiceLocator;
import org.kuali.rice.kns.service.KualiConfigurationService;
import org.kuali.rice.kns.util.KNSConstants;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the service implementation for a DateTime structure. This is
 * the default, Kuali delivered implementation.
 */
//@Transactional
public class DateTimeServiceImpl implements DateTimeService {
	protected String[] stringToDateFormats;
	protected String[] stringToTimestampFormats;
	protected String dateToStringFormatForUserInterface;
	protected String timestampToStringFormatForUserInterface;
	protected String dateToStringFormatForFileName;
	protected String timestampToStringFormatForFileName;

	public synchronized void initializeDateTimeService() {
		KualiConfigurationService kualiConfigurationService = KNSServiceLocator.getKualiConfigurationService();
		if (stringToDateFormats == null) {
			List<String> dateFormatParams = kualiConfigurationService.getParameterValues(KNSConstants.KNS_NAMESPACE, 
					KNSConstants.DetailTypes.ALL_DETAIL_TYPE, KNSConstants.SystemGroupParameterNames.STRING_TO_DATE_FORMATS);
			
			stringToDateFormats = new String[dateFormatParams.size()];
			
			for (int i = 0; i < dateFormatParams.size(); i++) {
				String dateFormatParam = dateFormatParams.get(i);
				if (StringUtils.isBlank(dateFormatParam)) {
					throw new IllegalArgumentException("KR-NS/All/STRING_TO_DATE_FORMATS parameter contains a blank semi-colon delimited substring");
				}
				else {
					// try to create a new SimpleDateFormat to try to detect illegal patterns
					new SimpleDateFormat(dateFormatParam);
					stringToDateFormats[i] = dateFormatParam;
				}
			}
		}
		
		if (stringToTimestampFormats == null) {
			List<String> dateFormatParams = kualiConfigurationService.getParameterValues(KNSConstants.KNS_NAMESPACE, 
					KNSConstants.DetailTypes.ALL_DETAIL_TYPE, KNSConstants.SystemGroupParameterNames.STRING_TO_TIMESTAMP_FORMATS);
			
			stringToTimestampFormats = new String[dateFormatParams.size()];
			
			for (int i = 0; i < dateFormatParams.size(); i++) {
				String dateFormatParam = dateFormatParams.get(i);
				if (StringUtils.isBlank(dateFormatParam)) {
					throw new IllegalArgumentException("KR-NS/All/STRING_TO_TIMESTAMP_FORMATS parameter contains a blank semi-colon delimited substring");
				}
				else {
					// try to create a new SimpleDateFormat to try to detect illegal patterns
					new SimpleDateFormat(dateFormatParam);
					stringToTimestampFormats[i] = dateFormatParam;
				}
			}
		}
		
		if (dateToStringFormatForUserInterface == null) {
			dateToStringFormatForUserInterface = kualiConfigurationService.getParameterValue(KNSConstants.KNS_NAMESPACE, 
					KNSConstants.DetailTypes.ALL_DETAIL_TYPE, KNSConstants.SystemGroupParameterNames.DATE_TO_STRING_FORMAT_FOR_USER_INTERFACE);
			// construct new SDF to make sure it's properly formatted
			new SimpleDateFormat(dateToStringFormatForUserInterface);
		}
		
		if (timestampToStringFormatForUserInterface == null) {
			timestampToStringFormatForUserInterface = kualiConfigurationService.getParameterValue(KNSConstants.KNS_NAMESPACE, 
					KNSConstants.DetailTypes.ALL_DETAIL_TYPE, KNSConstants.SystemGroupParameterNames.TIMESTAMP_TO_STRING_FORMAT_FOR_USER_INTERFACE);
			// construct new SDF to make sure it's properly formatted
			new SimpleDateFormat(timestampToStringFormatForUserInterface);
		}
		
		if (dateToStringFormatForFileName == null) {
			dateToStringFormatForFileName = kualiConfigurationService.getParameterValue(KNSConstants.KNS_NAMESPACE, 
					KNSConstants.DetailTypes.ALL_DETAIL_TYPE, KNSConstants.SystemGroupParameterNames.DATE_TO_STRING_FORMAT_FOR_FILE_NAME);
			// construct new SDF to make sure it's properly formatted
			new SimpleDateFormat(dateToStringFormatForFileName);
		}
		
		if (timestampToStringFormatForFileName == null) {
			timestampToStringFormatForFileName = kualiConfigurationService.getParameterValue(KNSConstants.KNS_NAMESPACE, 
					KNSConstants.DetailTypes.ALL_DETAIL_TYPE, KNSConstants.SystemGroupParameterNames.DATE_TO_STRING_FORMAT_FOR_FILE_NAME);
			// construct new SDF to make sure it's properly formatted
			new SimpleDateFormat(timestampToStringFormatForFileName);
		}
	}
	/**
	 * @see org.kuali.rice.kns.service.DateTimeService#toDateString(java.util.Date)
	 */
	public String toDateString(Date date) {
		return toString(date, dateToStringFormatForUserInterface);
	}

	/**
	 * @see org.kuali.rice.kns.service.DateTimeService#toDateTimeString(java.util.Date)
	 */
	public String toDateTimeString(Date date) {
		return toString(date, timestampToStringFormatForUserInterface);
	}

	/**
	 * @see org.kuali.rice.kns.service.DateTimeService#toString(java.util.Date,
	 *      java.lang.String)
	 */
	public String toString(Date date, String pattern) {
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		dateFormat.setLenient(false);
		return dateFormat.format(date);
	}

	/**
	 * @see org.kuali.rice.kns.service.DateTimeService#getCurrentDate()
	 */
	public Date getCurrentDate() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		return c.getTime();
	}

	/**
	 * @see org.kuali.rice.kns.service.DateTimeService#getCurrentTimestamp()
	 */
	public Timestamp getCurrentTimestamp() {
		return new java.sql.Timestamp(getCurrentDate().getTime());
	}

	/**
	 * @see org.kuali.rice.kns.service.DateTimeService#getCurrentSqlDate()
	 */
	public java.sql.Date getCurrentSqlDate() {
		return new java.sql.Date(getCurrentDate().getTime());
	}

	/**
	 * @see org.kuali.rice.kns.service.DateTimeService#getCurrentSqlDateMidnight()
	 */
	public java.sql.Date getCurrentSqlDateMidnight() {
		// simple and not unduely inefficient way to truncate the time component
		return java.sql.Date.valueOf(getCurrentSqlDate().toString());
	}

	/**
	 * @see org.kuali.rice.kns.service.DateTimeService#getCurrentCalendar()
	 */
	public Calendar getCurrentCalendar() {
		return getCalendar(getCurrentDate());
	}

	/**
	 * @see org.kuali.rice.kns.service.DateTimeService#getCalendar
	 */
	public Calendar getCalendar(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("invalid (null) date");
		}

		Calendar currentCalendar = Calendar.getInstance();
		currentCalendar.setTime(date);

		return currentCalendar;
	}

	/**
	 * Formats strings into dates using the format string in the KR-NS/All/STRING_TO_DATE_FORMATS parameter
	 * 
	 * @see org.kuali.rice.kns.service.DateTimeService#convertToDate(java.lang.String)
	 */
	public Date convertToDate(String dateString) throws ParseException {
		return parseAgainstFormatArray(dateString, stringToDateFormats);
	}

	/**
	 * @see org.kuali.rice.kns.service.DateTimeService#convertToDateTime(java.lang.String)
	 */
	public Date convertToDateTime(String dateTimeString) throws ParseException {
		if (StringUtils.isBlank(dateTimeString)) {
			throw new IllegalArgumentException("invalid (blank) date/time string");
		}
		return parseAgainstFormatArray(dateTimeString, stringToTimestampFormats);
	}

	/**
	 * @see org.kuali.rice.kns.service.DateTimeService#convertToSqlTimestamp(java.lang.String)
	 */
	public java.sql.Timestamp convertToSqlTimestamp(String timeString)
			throws ParseException {
		if (!StringUtils.isBlank(timeString)) {
			return new java.sql.Timestamp(convertToDateTime(timeString).getTime());
		}
        return null;
	}

	/**
	 * @see org.kuali.rice.kns.service.DateTimeService#convertToSqlDate(java.lang.String)
	 */
	public java.sql.Date convertToSqlDate(String dateString)
			throws ParseException {
		if (StringUtils.isBlank(dateString)) {
			throw new IllegalArgumentException("invalid (blank) timeString");
		}
		Date date = parseAgainstFormatArray(dateString, stringToDateFormats);
		return new java.sql.Date(date.getTime());
	}

	protected Date parseAgainstFormatArray(String dateString, String[] formats) throws ParseException {
		dateString = dateString.trim();
		StringBuffer exceptionMessage = new StringBuffer("Date or date/time string '")
				.append(dateString)
				.append("' could not be converted using any of the accepted formats: ");
		for (String dateFormatString : formats) {
			try {
				return parse(dateString, dateFormatString);
			} catch (ParseException e) {
				exceptionMessage.append(dateFormatString).append(
						" (error offset=").append(e.getErrorOffset()).append(
						"),");
			}
		}
		throw new ParseException(exceptionMessage.toString().substring(0,
				exceptionMessage.length() - 1), 0);
	}
	
	/**
	 * @throws ParseException
	 * @see org.kuali.rice.kns.service.DateTimeService#convertToSqlDate(java.sql.Timestamp)
	 */
	public java.sql.Date convertToSqlDate(Timestamp timestamp)
			throws ParseException {
		return new java.sql.Date(timestamp.getTime());
	}

	public int dateDiff(Date startDate, Date endDate, boolean inclusive) {
		Calendar startDateCalendar = Calendar.getInstance();
		startDateCalendar.setTime(startDate);

		Calendar endDateCalendar = Calendar.getInstance();
		endDateCalendar.setTime(endDate);

		int startDateOffset = -(startDateCalendar.get(Calendar.ZONE_OFFSET) + startDateCalendar
				.get(Calendar.DST_OFFSET))
				/ (60 * 1000);

		int endDateOffset = -(endDateCalendar.get(Calendar.ZONE_OFFSET) + endDateCalendar
				.get(Calendar.DST_OFFSET))
				/ (60 * 1000);

		if (startDateOffset > endDateOffset) {
			startDateCalendar.add(Calendar.MINUTE, endDateOffset
					- startDateOffset);
		}

		if (inclusive) {
			startDateCalendar.add(Calendar.DATE, -1);
		}

		int dateDiff = Integer.parseInt(DurationFormatUtils.formatDuration(
				endDateCalendar.getTimeInMillis()
						- startDateCalendar.getTimeInMillis(), "d", true));

		return dateDiff;
	}

	protected Date parse(String dateString, String pattern) throws ParseException {
		if (!StringUtils.isBlank(dateString)) {
			DateFormat dateFormat = new SimpleDateFormat(pattern);
			dateFormat.setLenient(false);
			return dateFormat.parse(dateString);
		}
		return null;
	}

	/**
	 * @see org.kuali.rice.kns.service.DateTimeService#toDateStringForFilename(java.util.Date)
	 */
	public String toDateStringForFilename(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateToStringFormatForFileName);
		return dateFormat.format(date);
	}

	/**
	 * @see org.kuali.rice.kns.service.DateTimeService#toDateTimeStringForFilename(java.util.Date)
	 */
	public String toDateTimeStringForFilename(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(timestampToStringFormatForFileName);
		return dateFormat.format(date);
	}
}