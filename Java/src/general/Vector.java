package general;

public interface Vector {
  
  /**
   * Получить некоторую координату вектора.
   * @param what номер координаты.
   * @return координата.
   */
  double getCoordinate(int what);


  /**  
   * @param v вектор
   * @return cкалярное произведение вектора this на v. 
   */
  double scalar(Vector v); // скалярное произведение векторов
  /**
   * @return длина вектора.
   */
  double len();
  
  Vector multiply(double factor); // умножение на число
  Vector add(Vector v); // сложение векторов
  Vector sub(Vector v); // вычитание векторов
  int getDimension(); //Получить
}
