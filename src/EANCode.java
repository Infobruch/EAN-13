public class EANCode {
  // Anfang Attribute
  // Ende Attribute

  public EANCode() {
  }

  // Anfang Methoden
  public static boolean istKorrekt(String pEingabe) {

    if (!istNummer(pEingabe) || pEingabe.length() != 13) {
      return false;
    }

    int[] feld = new int[12];
    for (int i = 0; i < 12; i++) {
      feld[i] = pEingabe.charAt(i)-48;
    } // end of for

    return berechnePruefziffer(feld) == (pEingabe.charAt(12)-48);
  }

  private static boolean istNummer(String pEingabe) {
    for (int i=0;i<pEingabe.length() ; i++ ) {
      if (pEingabe.charAt(i) < 48 || pEingabe.charAt(i) > 57 ) {
        return false;
      }
    }
    return true;
  }

  public static int berechnePruefziffer(int[] pFeld) {
    int sum_even = 0;
    int sum_odd = 0;

    for (int i = 0; i < 12; i++) {
      if (i % 2 == 0) {
        sum_even += pFeld[i];
      } else {
        sum_odd += pFeld[i] * 3;
      }
    }

    int total = sum_even + sum_odd;
    return (10 - (total % 10)) % 10;
  }
  // Ende Methoden
}
