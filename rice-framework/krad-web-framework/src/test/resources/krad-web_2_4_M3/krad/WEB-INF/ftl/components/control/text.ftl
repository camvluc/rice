<#--

    Copyright 2005-2014 The Kuali Foundation

    Licensed under the Educational Community License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.opensource.org/licenses/ecl2.php

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

-->
<#--
    Standard HTML Text Input

 -->

<#macro uif_text control field>

    <#local attributes='size="${control.size!}" class="${control.styleClassesAsString!}"
         tabindex="${control.tabIndex!}"  ${control.simpleDataAttributes!}'/>

    <#if control.disabled>
        <#local attributes='${attributes} disabled="disabled"'/>
    </#if>

    <#if control.readOnly  || field.widgetInputOnly!false>
        <#local attributes='${attributes} readonly="readonly"'/>
    </#if>

    <#if control.style?has_content>
        <#local attributes='${attributes} style="${control.style}"'/>
    </#if>

    <#if control.maxLength??>
        <#local attributes='${attributes} maxlength="${control.maxLength}"'/>
    </#if>

    <#if control.minLength??>
        <#local attributes='${attributes} minLength="${control.minLength}"'/>
    </#if>

    <#if field.disableNativeAutocomplete>
        <#local attributes='${attributes} autocomplete="off"'/>
    </#if>

    <@spring.formInput id="${control.id}" path="KualiForm.${field.bindingInfo.bindingPath}" attributes="${attributes}"/>

    <#if control.watermarkText?has_content>
        <@krad.script value="createWatermark('${control.id}', '${control.watermarkText?js_string}');"/>
    </#if>

    <#-- render date picker widget -->
    <@krad.template component=control.datePicker componentId="${control.id}"/>

    <#if control.textExpand>
        <@krad.script value="setupTextPopout('${control.id}', '${field.label!}', '${(field.instructionalMessage.messageText?js_string)!}', '${(field.constraintMessage.messageText?js_string)!}');" />
    </#if>

    <@krad.disable control=field.control type="text"/>

</#macro>