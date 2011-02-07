/*
 * Copyright 2007 The Kuali Foundation
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
package org.kuali.rice.kns.web.spring.form;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import edu.sampleu.travel.bo.TravelAccount;

/**
 * Form for Test UI Page
 * 
 * @author Kuali Rice Team (rice.collab@kuali.org)
 */
public class UITestForm extends UifFormBase {
	private String field1;
	private String field2;
	private String field3;
	private String field4;
	private String field5;
	private Date field6;
	private int field7;
	private boolean field8;

	private boolean field9;
	private boolean field10;
	private boolean field11;
	private boolean field12;

	private String field13;
	private String field14;
	private String field15;
	private String field16;
	private String field17;
	private String field18;
	private String field19;
	private String field20;
	private String field21;
	private boolean field22;
	private String field23;
	private boolean field24;
	private boolean field25;
	private boolean field26;
	private String field27;
	private String field28;
	private boolean field29;
	private boolean field30;
	private boolean field31;
	private String field32;
	private String field33;

	private TravelAccount travelAccount1;
	private TravelAccount travelAccount2;
	private TravelAccount travelAccount3;

	public UITestForm() {
		super();
		travelAccount1 = new TravelAccount();
		newCollectionLines.put("travelAccount1.fiscalOfficer.accounts", new TravelAccount());
		newCollectionLines.put("travelAccount2.fiscalOfficer.accounts", new TravelAccount());
	}

	@Override
	public void postBind(HttpServletRequest request) {
		super.postBind(request);

		// TODO: remove once the view is being pulled from session or
		// reconstructed by the binding
		getViewService().updateView(view, this);
	}

	public String getField1() {
		return this.field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return this.field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return this.field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getField4() {
		return this.field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}

	public String getField5() {
		return this.field5;
	}

	public void setField5(String field5) {
		this.field5 = field5;
	}

	public Date getField6() {
		return this.field6;
	}

	public void setField6(Date field6) {
		this.field6 = field6;
	}

	public int getField7() {
		return this.field7;
	}

	public void setField7(int field7) {
		this.field7 = field7;
	}

	public boolean isField8() {
		return this.field8;
	}

	public void setField8(boolean field8) {
		this.field8 = field8;
	}

	public TravelAccount getTravelAccount1() {
		return this.travelAccount1;
	}

	public void setTravelAccount1(TravelAccount travelAccount1) {
		this.travelAccount1 = travelAccount1;
	}

	public boolean isField9() {
		return this.field9;
	}

	public void setField9(boolean field9) {
		this.field9 = field9;
	}

	public boolean isField10() {
		return this.field10;
	}

	public void setField10(boolean field10) {
		this.field10 = field10;
	}

	public boolean isField11() {
		return this.field11;
	}

	public void setField11(boolean field11) {
		this.field11 = field11;
	}

	public boolean isField12() {
		return this.field12;
	}

	public void setField12(boolean field12) {
		this.field12 = field12;
	}

	public String getField13() {
		return this.field13;
	}

	public void setField13(String field13) {
		this.field13 = field13;
	}

	public String getField14() {
		return this.field14;
	}

	public void setField14(String field14) {
		this.field14 = field14;
	}

	public String getField15() {
		return this.field15;
	}

	public void setField15(String field15) {
		this.field15 = field15;
	}

	public String getField16() {
		return this.field16;
	}

	public void setField16(String field16) {
		this.field16 = field16;
	}

	public String getField17() {
		return this.field17;
	}

	public void setField17(String field17) {
		this.field17 = field17;
	}

	public String getField18() {
		return this.field18;
	}

	public void setField18(String field18) {
		this.field18 = field18;
	}

	public String getField19() {
		return this.field19;
	}

	public void setField19(String field19) {
		this.field19 = field19;
	}

	public String getField20() {
		return this.field20;
	}

	public void setField20(String field20) {
		this.field20 = field20;
	}

	public String getField21() {
		return this.field21;
	}

	public void setField21(String field21) {
		this.field21 = field21;
	}

	public boolean isField22() {
		return this.field22;
	}

	public void setField22(boolean field22) {
		this.field22 = field22;
	}

	public String getField23() {
		return this.field23;
	}

	public void setField23(String field23) {
		this.field23 = field23;
	}

	public boolean isField24() {
		return this.field24;
	}

	public void setField24(boolean field24) {
		this.field24 = field24;
	}

	public boolean isField25() {
		return this.field25;
	}

	public void setField25(boolean field25) {
		this.field25 = field25;
	}

	public boolean isField26() {
		return this.field26;
	}

	public void setField26(boolean field26) {
		this.field26 = field26;
	}

	public String getField27() {
		return this.field27;
	}

	public void setField27(String field27) {
		this.field27 = field27;
	}

	public String getField28() {
		return this.field28;
	}

	public void setField28(String field28) {
		this.field28 = field28;
	}

	public boolean isField29() {
		return this.field29;
	}

	public void setField29(boolean field29) {
		this.field29 = field29;
	}

	public boolean isField30() {
		return this.field30;
	}

	public void setField30(boolean field30) {
		this.field30 = field30;
	}

	public boolean isField31() {
		return this.field31;
	}

	public void setField31(boolean field31) {
		this.field31 = field31;
	}

	public String getField32() {
		return this.field32;
	}

	public void setField32(String field32) {
		this.field32 = field32;
	}

	public String getField33() {
		return this.field33;
	}

	public void setField33(String field33) {
		this.field33 = field33;
	}

	public TravelAccount getTravelAccount2() {
		return this.travelAccount2;
	}

	public void setTravelAccount2(TravelAccount travelAccount2) {
		this.travelAccount2 = travelAccount2;
	}

	public TravelAccount getTravelAccount3() {
		return this.travelAccount3;
	}

	public void setTravelAccount3(TravelAccount travelAccount3) {
		this.travelAccount3 = travelAccount3;
	}

}
