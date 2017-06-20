import junit.framework.Assert.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class Tests {


    @Test
    fun charTest(){
        assertEquals(" 2 3 4",forChar(2,7,"1 2 3 4 5"))
        assertEquals("3456", forChar(3,6,"123456"))
        assertEquals("my", forChar(1,2,"my mother"))
    }

    @Test
    fun wordTest(){
        assertEquals("2 3 4 5", forWord(2,5,"1 2 3 4 5 6"))
        assertEquals("1 2", forWord(1,2,"1 2 3 "))
        assertEquals("mother", forWord(2, 2, "my mother"))
    }

    @Test
    fun argParsing() {
        val arr = ArrayList<String>()
        val args = ArrayList<String>()
        arr.add("file")
        arr.add("35")
        arr.add("10")
        args.add("file")
        args.add("35-10")
        assertEquals(arr, Parsing(args))

        arr.clear()
        args.clear()
        arr.add("")
        arr.add("1")
        arr.add("100")
        args.add("")
        args.add("1-100")
        assertEquals(arr, Parsing(args))

        arr.clear()
        args.clear()
        args.add("file")
        args.add("5-")
        arr.add("file")
        arr.add("5")
        arr.add("-1")
        assertEquals(arr, Parsing(args))
    }

}