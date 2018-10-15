
package lolcode_compiler;

/**
 *
 * @author Dheeraj
 */
public class lexemes {
    //ALL THE KEYWORDS DEFINED BELOW
    final static String HAS = "HAS";
    final static String SAEM = "SAEM";
    final static String OF = "OF";
    final static String RLY = "RLY";
    final static String QUESTION = "?";
    final static String DOC_BEGIN = "HAI";
    final static String A = "A";
     final static String AN = "AN";
	final static String DOC_END = "KTHXBYE";
        final static String SINGLE_COMMENT = "BTW";
	final static String COMMENT_BEGIN = "OBTW";
	final static String COMMENT_END = "TLDR";
        final static String LIBRARY_CHECK = "CAN";
        final static String BOTH_SAME_EXP = "BOTH";
        final static String BOTH_DIFF_EXP = "DIFFRINT";
        final static String BIGGER_COMP = "BIGGR";
        final static String SMALLER_COMP = "SMALLR";
        final static String SUM = "SUM";
        final static String DIFF = "DIFF";
        final static String PRODUCT = "PRODUKT";
        final static String QUOTIENT = "QUOSHUNT";
        final static String MOD = "MOD";
        final static String SMOOSH = "SMOOSH";
        final static String O = "O";
        final static String YA = "YA";
        final static String NO = "NO";
        final static String WAY = "WAY";
        final static String OIC = "OIC";
        final static String WTF = "WTF?";
        final static String OMG = "OMG";
        final static String OMGWTF = "OMGWTF";
        final static String GIMMEH_END = "MKAY";          
        final static String VARIABLE_BEGIN = "I";
        final static String ITZ = "ITZ";       
        final static String VARIABLE_CALL = "VISIBLE";
        final static String GIMMEH = "GIMMEH";
        //
        //LIBRABRIES
        final static String STDIO = "STDIO?";
        
                private String info;
        
    /**
     * 
     * @param info
     */
    public lexemes(String info)
        {
            this.info = info;
        }
        
    /**
     * 
     * @return info of the token
     */
    public String getToken()
        {
            return info;
        }
}
