package com.readExcel.read.code;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.xwork.StringUtils;

import com.readExcel.read.bean.FospEifMccDo;

public enum COLUMNS {
	
	DECLTYPE("申請書類別", false), //
	PORT("港口別", false), // (A：基隆, B：高雄, D：台中)
	CUSTID("關別代碼", false), //
	DECLNO("申請書號碼(進口編號)", false), //
	PORTID("起運口岸", false), //
	STORWARECD("目的地(卸存地)代碼", false), //
	STATDATE("統計月份", false) {
		@Override
		public FospEifMccDo set(FospEifMccDo fospEifMccDo, String value) {
			fospEifMccDo.setValue(this.name(), value);
			return fospEifMccDo;
		}
	}, //
	GROSS("毛重", false) {
		@Override
		public FospEifMccDo set(FospEifMccDo fospEifMccDo, String value) {
			if (StringUtils.isNotBlank(value)) {
				fospEifMccDo.setValue(this.name(), new BigDecimal(value));
			}

			return fospEifMccDo;
		}
	}, //
	TRANSCUSID("轉至關別", false), //
	IM_VESSEL_REG_NO("海關通關號碼-進口", false), //
	IM_MANIF_NO("艙單號碼-進口", false), //
	IM_MAWB_NO("主提單號碼-進口", false), //
	IM_HAWB_NO("分提單號碼-進口", false), //
	EX_VESSEL_REG_NO("海關通關號碼-出口", false), //
	EX_MANIF_NO("裝貨單號碼-出口", false), //
	EX_MAWB_NO("託運單主號-出口", false), //
	EX_HAWB_NO("託運單分號-出口", false), //
	DESCRIP("貨物名稱", false), //
	CONTR_NO("貨櫃號碼", false), //
	SHIPMENT_PLACE_CODE("起運地點代碼", false), //

	NOFILE("查無欄位", false) {
		@Override
		public FospEifMccDo set(FospEifMccDo fospEifMccDo, String value) {

			return fospEifMccDo;
		}
	}, //
	;//
	final String chineseName;
	final boolean isPK;

	private COLUMNS(String chineseName, boolean isPK) {
		this.chineseName = chineseName;
		this.isPK = isPK;
	}

	public String getChineseName() {
		return chineseName;
	}

	public boolean isPK() {
		return isPK;
	}
	
	public FospEifMccDo set(FospEifMccDo fospEifMccDo, String value) {
		fospEifMccDo.setValue(this.name(), value);
		return fospEifMccDo;
	}

	final static Map<String, COLUMNS> MAP;
	static {
		final Map<String, COLUMNS> contractMap = new HashMap<String, COLUMNS>();
		final EnumSet<COLUMNS> contracts = EnumSet.allOf(COLUMNS.class);
		for (COLUMNS contract : contracts) {
			contractMap.put(contract.chineseName, contract);
		}
		MAP = Collections.unmodifiableMap(contractMap);
	}

	public static COLUMNS lookup(String chineseName) {

		for (Map.Entry<String, COLUMNS> entry : MAP.entrySet()) {
			if (chineseName.startsWith(entry.getKey())) {
				return entry.getValue();
			}

		}
		return null;
	}

}
