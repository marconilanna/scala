import scala.collection.immutable.Map;
import scala.collection.immutable.TreeMap;
import scala.collection.immutable.ListMap;
import scala.collection.immutable.Order;

object Test with Executable {
    //    test1();
    test2();
    Console.println("OK");

    val intOrder =
	new Order((x:int,y:int) => x < y, (x:int,y:int) => x == y);

    def test1() = {
	val myMap:TreeMap[int,String] = new TreeMap(intOrder);
	test_map(myMap);
    }

    def test2() = {
	val myMap:ListMap[int,String] = new ListMap;
	test_map(myMap);
    }

    def test_map[This <: Map[int,String,This]](myMap:Map[int,String,This]) = {
	val map1 = myMap.update(42,"The answer");
	val map2 = map1.update(17,"A small random number");
	val map3 = map2.update(666,"A bigger random number");
	val map4 = map3.update(4711,"A big random number");
	//	val map1 = myMap + 42 -> "The answer";
	Console.println(map4);
	var i = 0;
	var map = map4;
	while(i < 43) {
	    map = map.update(i,i.toString());
	    i = i + 1;
	}
	i = 0;
	while(i < 4712) {
	    if(map.isDefinedAt(i))
		Console.print(i + "->" + map(i) + " ");
	    i = i + 1;
	}
	Console.println("");
    }
}


