package view;

import java.util.HashMap;
import java.util.TreeSet;

import model.CharWorker;

/**
 * Класс предназначен для удобного вывода класса CharWorker.
 * @author ld
 *
 */
public class MySimpleView {
  final CharWorker worker;
  /**
   * Конструктор принимающий объект класса CharWorker.
   * @param worker 
   * @throws NullPointerException
   */
  public MySimpleView(CharWorker worker) throws NullPointerException {
    if (worker == null) throw new NullPointerException("worker is null!");
    this.worker = worker;
  }
  /**
   * Вывод в формате a - 1\nb - 3\nc-4\n... 
   * @return строка с представлением (:
   */
  public String getRepresentation () {
    HashMap<Character, Integer> currentState = worker.getCurrentState();
    StringBuffer stringBuffer = new StringBuffer();
    for (char c : new TreeSet<Character>(currentState.keySet())) {
      stringBuffer.append(c);
      stringBuffer.append(" - ");
      stringBuffer.append(currentState.get(c));
      stringBuffer.append("\n");
    }
    return stringBuffer.toString();    
  }
}
