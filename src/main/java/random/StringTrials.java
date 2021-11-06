package random;

import java.util.Arrays;
import java.util.HashSet;

/** Created on Sun, 1/10/21 at 1:05 PM by Genil. */
public class StringTrials {
  public static void main(String[] args) {

    String splitStr = "KEY/EMD";
    System.out.println(splitStr.split("/")[0]);

    String hmtStrings =
        "WCBD\n" + "WCBW\n" + "WCHC\n" + "WCHR\n" + "WCHS\n" + "WCMP\n" + "WCOB\n" + "CHD\n"
            + "DCVI\n" + "IFAC\n" + "IFBP\n" + "IFCF\n" + "IFET\n" + "IFEX\n" + "INF\n" + "UMNR\n"
            + "VIDI\n" + "VINF\n" + "AVIH\n" + "ESAN\n" + "PETC\n" + "SVAN\n" + "BLND\n" + "DEAF\n"
            + "DPNA\n" + "LANG\n" + "MAAS\n" + "MEDA\n" + "WCLB";
    String[] hmtStringArray = hmtStrings.split("\n");
    System.out.println("HMT strings "+ Arrays.toString(hmtStringArray));

    System.out.println("# of codes by HMT " + hmtStringArray.length);
    String processorStr =
        "BLND,DEAF,DPNA,MAAS,MEDA,TWOV,UMNR,WCBD,WCBW,WCHC,WCHR,WCHS,WCMP,WCOB,ESAN,LANG,SVAN,DOCS";
    String[] processorStrArray = processorStr.split(",");
    System.out.println("# of codes today by processor " + processorStrArray.length);

    HashSet<String> ssrCodeSet = new HashSet<>(Arrays.asList(processorStrArray));
    StringBuffer stringBuffer = new StringBuffer(",");
    for (String s : hmtStringArray) {
      if (ssrCodeSet.add(s)) {
        System.out.println(s + " to be added");
        stringBuffer.append(s);
        stringBuffer.append(",");
      }
    }
    System.out.println("Final list " + stringBuffer);
  }
}
