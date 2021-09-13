package cenk.st.jpa.common;

import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public interface StConstants {
	//	static final String[] MARKET_NAMES = new String[] { "METAL", "MONEY", "STOCK", "BOND", "COMMODITY", "CRYPTO"};
	//	static final boolean[] MARKET_WITH_INTEREST = new boolean[] { false, true, true, true, false, false};
	//	static final String[] CURRENCY_CODES = new String[] { "GBP", "HKD", "IDR", "ILS", "DKK", "INR", "CHF", "MXN",
	//			"CZK", "SGD", "THB", "HRK", "MYR", "NOK", "CNY", "BGN", "PHP", "SEK", "PLN", "ZAR", "CAD", "ISK", "BRL",
	//			"RON", "NZD", "TRY", "JPY", "RUB", "KRW", "USD", "HUF", "AUD", "EUR" };
	//	static final String[] METAL_CODES = new String[] { "XAU", "XAG", "XPT", "XPD"};
	//	static final String[] CRYPTO_CODES = new String[] { "BTC", "ETH", "BNB", "XRP"};
	//	static final String[] STOCK_CODES = new String[] { "DOW", "AAPL", "BIST"};

	static final String[] MARKET_NAMES = new String[] { "METAL", "MONEY"};
	static final boolean[] MARKET_WITH_INTEREST = new boolean[] { false, true};
	static final String[] CURRENCY_CODES = new String[] { "USD", "TRY", "EUR" };
	static final String[] STOCK_CODES = new String[] {};
	static final String[] METAL_CODES = new String[] { "XAU"};
	static final String[] CRYPTO_CODES = new String[] {};
	static final ObjectMapper JACKSON_MAPPER = new ObjectMapper();

	static final ObjectWriter JACKSON_WRITER = JACKSON_MAPPER.writer().withDefaultPrettyPrinter();
	static final int UNKNOWN_ERROR_CODE = 9000;

	static final String UNKNOWN_ERROR_MESSAGE = "An uncategorized error occured. Please check server's log";

	static final String OPP_COST_OUT_CURRENCY = "OC_OUT";

	static final String OPP_COST_CALCULATION_CURRENCY = "OC_CALC";

	static final String CASH_FLOW_IN_CURRENCY = "CF_IN";

	static final DateTimeFormatter RATES_API_DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE;

	static final DateTimeFormatter TURKEY_LINE_SEPERATED_DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

}
