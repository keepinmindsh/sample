package lines.jasper.util;

import org.apache.commons.lang3.StringEscapeUtils;

public class StringUtil {

    public static String unescapeHtml(String s)
    {
        return StringEscapeUtils.unescapeHtml4(s.replace("&amp;#39;", "`").replace("&apos;", "'"));
    }

}
