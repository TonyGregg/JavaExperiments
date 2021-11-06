package random;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/** Created on Fri, 5/21/21 at 6:57 AM by Genil. */
public class DateFormatter {
  public static void main(String[] args) {
    String inputDate = "28JUN2021";
    String inputTime = "11:59 PM";

    LocalDate localDate = getLocalDate(inputDate+inputTime, "GMT");
    System.out.println("LocalDate " + localDate);

  }

  private static java.time.LocalDate getLocalDate(String dateTimeStr, String zoneId) {
    Date date;
    LocalDate localDate = null;

    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMMyyyyh:mm a");
      date =  simpleDateFormat.parse(dateTimeStr);
      if (ZoneId.SHORT_IDS.containsKey(zoneId)) {
        localDate = date.toInstant().atZone(ZoneId.of(ZoneId.SHORT_IDS.get(zoneId))).toLocalDate();
      } else {
        localDate = date.toInstant().atZone(ZoneId.of(zoneId)).toLocalDate();

      }
    } catch (ParseException parseException) {
      parseException.printStackTrace();
    }

    return localDate;
  }

  private static java.time.LocalDate getLocalDate(Date date, String zoneId) {
    LocalDate localDate = null;
    if (ZoneId.SHORT_IDS.containsKey(zoneId)) {
      localDate = date.toInstant().atZone(ZoneId.of(ZoneId.SHORT_IDS.get(zoneId))).toLocalDate();
    } else {
      localDate = date.toInstant().atZone(ZoneId.of(zoneId)).toLocalDate();

    }
    return localDate;
  }

  public static Date fromDDMMMYYYYHMMA(String str) {
    try {
      SimpleDateFormat sdfDDMMMYYYYHMMWITHGMT = new SimpleDateFormat("ddMMMyyyyh:mm a");
      return sdfDDMMMYYYYHMMWITHGMT.parse(str);
    } catch (ParseException var2) {
      var2.printStackTrace();
      return null;
    }
  }

  public static Date fromYYYYMMDDHHMM(String str) {
    try {
      SimpleDateFormat sdfYYYYMMDDHHMM = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
      return sdfYYYYMMDDHHMM.parse(str);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }
}
