//Фаткуллин Виль 11-306 Вариант 2
public class Main {
    public static void main(String[] args) {
        CustomMap<String, Integer> map = new CustomMap<>();

        map.put("один", 1);
        map.put("два", 2);
        map.put("три", 3);

        System.out.println("Значение для ключа 'два': " + map.get("два"));

        System.out.println("Удаление ключа 'два'");
        map.remove("два");

        System.out.println("Содержит ключ 'три': " + map.containsKey("три"));
        System.out.println("Содержит значение 1: " + map.containsValue(1));
    }
}
