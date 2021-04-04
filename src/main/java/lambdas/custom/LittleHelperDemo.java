package lambdas.custom;
/** Created by Antony Genil on 1/19/20 at 13 46 for JavaExperiments */
public class LittleHelperDemo {
  public static void main(String[] args) {
    LittleHelperDemo demo = new LittleHelperDemo();

    String mailOut = demo.doAnything(littleHelper -> littleHelper.checkMailPosts());
    System.out.println(mailOut);

    String groceryItems = demo.doAnything(errands -> errands.buyGroceries("Patels"));
    System.out.printf("Brought groceries. Items " + groceryItems);
    System.out.println(demo.doAnything(littleHelper -> littleHelper.getBooksFromLibrary("Naperville")));

    String multipleActivities =
        demo.doAnything(
            errands -> {
              return errands.getBooksFromLibrary("Eola")
                  + errands.checkMailPosts()
                  + " Do something on your own activity, for example: Watch TV";
            });
    System.out.println("\n\nMultiple things " + multipleActivities);
  }

  public String doAnything(LittleHelper helper) {
    System.out.println("\n--Inside do Anything method. --");
    Errands errands = new Errands();
    return helper.doThings(errands);
  }
}
