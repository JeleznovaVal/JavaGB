public class Main {
  public static void main(String[] args) {
    String[] headers = {"text 1", "text 2"};
    int[][] data = { {1,2}, {2,3} };
    AppData appdata = new AppData(headers, data);
    appdata.writeCSV("file1");
    appdata.readCSV("file2");
    String[] headerRead = appdata.getHeader();
    int[][] dataRead = appdata.getData();
    for (int i = 0; i < headerRead.length; i++) {
      System.out.print(headerRead[i] + "; ");
    }
    System.out.println();
    for (int i = 0; i < dataRead.length; i++) {
      for (int j = 0; j < dataRead[0].length; j++) {
        System.out.print(dataRead[i][j]+ "; ") ;
      }
      System.out.println();
    }
  }
}

