import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppData {
  private String[] header;
  private int[][] data;

  public AppData(String[] header, int[][] data) {
    this.header = header;
    this.data = data;
  }

  public String[] getHeader() {
    return header;
  }
  public int[][] getData() {
    return data;
  }
  public void writeCSV(String fileName) {
    try (PrintWriter writer = new PrintWriter(new File(fileName + ".csv"))) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < this.header.length; i++) {
        sb.append(header[i]);
        sb.append(";");
      }
      sb.append("\n");
      for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[0].length; j++) {
          sb.append(data[i][j]);
          sb.append(";");
        }
        sb.append("\n");
      }
      writer.write(sb.toString());
      writer.close();
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }

  public void readCSV(String fileName) {
    List<List<String>> records = new ArrayList<>();
    try (Scanner scanner = new Scanner(new File(fileName + ".csv"));) {
      while (scanner.hasNextLine()) {
        records.add(getRecordFromLine(scanner.nextLine()));
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    String[] headerToRead = new String[records.get(0).size()];
    for (int i = 0; i < headerToRead.length; i++) {
      headerToRead[i] = records.get(0).toArray()[i].toString();
    }
    this.header = headerToRead;
    int[][] dataToRead = new int[records.size() - 1][records.get(0).size()];
    for (int i = 0; i < dataToRead.length; i++) {
      for (int j = 0; j < dataToRead[0].length; j++) {
        dataToRead[i][j] = Integer.parseInt(records.get(i + 1).toArray()[j].toString());
      }
    }
    this.data = dataToRead;

  }
  private List<String> getRecordFromLine(String line) {
    List<String> values = new ArrayList<String>();
    try (Scanner rowScanner = new Scanner(line)) {
      rowScanner.useDelimiter(";");
        while (rowScanner.hasNext()) {
            values.add(rowScanner.next());
        }
    }
    return values;
}
}
