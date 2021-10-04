package com.readExcel.read.bean;

import java.util.HashMap;
import java.util.Map;
 
public class FospEifMccDo { 
	protected Map values = new HashMap();
	protected boolean keySensitive = true;
 
	public enum COLUMNS { 
		DECLTYPE("申請書類別"), 
		PORT("港口別(A：基隆, B：高雄, D：台中)"), 
		CUSTID("關別代碼"), 
		DECLNO("申請書號碼(進口編號)"), 
		PORTID("起運口岸"), 
		STORWARECD("目的地(卸存地)代碼"), 
		STATDATE("統計月份(年月)"), 
		GROSS("毛重"), 
		TRANSCUSID("轉至關別"), 
		IM_VESSEL_REG_NO("海關通關號碼-進口"), 
		IM_MANIF_NO("艙單號碼-進口"), 
		IM_MAWB_NO("主提單號碼-進口"), 
		IM_HAWB_NO("分提單號碼-進口"), 
		EX_VESSEL_REG_NO("海關通關號碼-出口"), 
		EX_MANIF_NO("裝貨號碼-出口"), 
		EX_MAWB_NO("託運單主號-出口"), 
		EX_HAWB_NO("託運單分號-出口"), 
		DESCRIP("貨物名稱"), 
		CONTR_NO("貨櫃櫃號"), 
		SHIPMENT_PLACE_CODE("起運地點代碼") 
		; 
		final String name; 
	 
		private COLUMNS(final String name) { 
			this.name = name; 
		} 
	 
		public String getName() { 
			return this.name; 
		} 
	} 
 
	private String decltype; 
	private String port; 
	private String custid; 
	private String declno; 
	private String portid; 
	private String storwarecd; 
	private String statdate; 
	private String gross; 
	private String transcusid; 
	private String imVesselRegNo; 
	private String imManifNo; 
	private String imMawbNo; 
	private String imHawbNo; 
	private String exVesselRegNo; 
	private String exManifNo; 
	private String exMawbNo; 
	private String exHawbNo; 
	private String descrip; 
	private String contrNo; 
	private String shipmentPlaceCode; 
	
	public String getDecltype() { 
		return decltype; 
	} 
 
	public void setDecltype(String decltype) { 
		this.decltype = decltype; 
	} 
 
	public String getPort() { 
		return port; 
	} 
 
	public void setPort(String port) { 
		this.port = port; 
	} 
 
	public String getCustid() { 
		return custid; 
	} 
 
	public void setCustid(String custid) { 
		this.custid = custid; 
	} 
 
	public String getDeclno() { 
		return declno; 
	} 
 
	public void setDeclno(String declno) { 
		this.declno = declno; 
	} 
 
	public String getPortid() { 
		return portid; 
	} 
 
	public void setPortid(String portid) { 
		this.portid = portid; 
	} 
 
	public String getStorwarecd() { 
		return storwarecd; 
	} 
 
	public void setStorwarecd(String storwarecd) { 
		this.storwarecd = storwarecd; 
	} 
 
	public String getStatdate() { 
		return statdate; 
	} 
 
	public void setStatdate(String statdate) { 
		this.statdate = statdate; 
	} 
 
	public String getGross() { 
		return gross; 
	} 
 
	public void setGross(String gross) { 
		this.gross = gross; 
	} 
 
	public String getTranscusid() { 
		return transcusid; 
	} 
 
	public void setTranscusid(String transcusid) { 
		this.transcusid = transcusid; 
	} 
 
	public String getImVesselRegNo() { 
		return imVesselRegNo; 
	} 
 
	public void setImVesselRegNo(String imVesselRegNo) { 
		this.imVesselRegNo = imVesselRegNo; 
	} 
 
	public String getImManifNo() { 
		return imManifNo; 
	} 
 
	public void setImManifNo(String imManifNo) { 
		this.imManifNo = imManifNo; 
	} 
 
	public String getImMawbNo() { 
		return imMawbNo; 
	} 
 
	public void setImMawbNo(String imMawbNo) { 
		this.imMawbNo = imMawbNo; 
	} 
 
	public String getImHawbNo() { 
		return imHawbNo; 
	} 
 
	public void setImHawbNo(String imHawbNo) { 
		this.imHawbNo = imHawbNo; 
	} 
 
	public String getExVesselRegNo() { 
		return exVesselRegNo; 
	} 
 
	public void setExVesselRegNo(String exVesselRegNo) { 
		this.exVesselRegNo = exVesselRegNo; 
	} 
 
	public String getExManifNo() { 
		return exManifNo; 
	} 
 
	public void setExManifNo(String exManifNo) { 
		this.exManifNo = exManifNo; 
	} 
 
	public String getExMawbNo() { 
		return exMawbNo; 
	} 
 
	public void setExMawbNo(String exMawbNo) { 
		this.exMawbNo = exMawbNo; 
	} 
 
	public String getExHawbNo() { 
		return exHawbNo; 
	} 
 
	public void setExHawbNo(String exHawbNo) { 
		this.exHawbNo = exHawbNo; 
	} 
 
	public String getDescrip() { 
		return descrip; 
	} 
 
	public void setDescrip(String descrip) { 
		this.descrip = descrip; 
	} 
 
	public String getContrNo() { 
		return contrNo; 
	} 
 
	public void setContrNo(String contrNo) { 
		this.contrNo = contrNo; 
	} 
 
	public String getShipmentPlaceCode() { 
		return shipmentPlaceCode; 
	} 
 
	public void setShipmentPlaceCode(String shipmentPlaceCode) { 
		this.shipmentPlaceCode = shipmentPlaceCode; 
	} 
	
	public void setValue(String key, Object value) {
		if (key != null) {
			if (this.keySensitive) {
				this.values.put(key, value);
			} else {
				this.values.put(key.toUpperCase(), value);
			}
		}

	}
 
} 
