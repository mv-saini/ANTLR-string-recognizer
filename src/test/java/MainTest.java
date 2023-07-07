import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void program() {
        //INPUT 1 FROM PROJECT INSTRUCTION FILE
        assertEquals("OK, KO, OK, KO", Main.program("a + b c, a, b, bc, ad"));

        //INPUT 2 FROM PROJECT INSTRUCTION FILE
        assertEquals("OK, KO, OK, KO, OK, KO", Main.program("a * (b+epsilon), aab, ba, b, abb, a, c"));

        //INPUT 3 FROM PROJECT INSTRUCTION FILE
        assertEquals("OK, OK, KO, KO, KO", Main.program("(a+ b)*abb, aabb, abbbabb, abbb, ab, acbabb"));

        //INPUT 4 FROM PROJECT INSTRUCTION FILE
        assertEquals("OK, OK, KO, OK, KO, KO", Main.program("a+b*abb, a, bbbabb, abbb, abb, abaabb, abcabb"));

        //INPUT 5 FROM PROJECT INSTRUCTION FILE (THROWS EXCEPTION BECAUSE INVALID INPUT)
        assertThrows(RuntimeException.class, ()->{
            Main.program("a++c, a, c, acc");
        });

        //INPUT 6 (THROWS EXCEPTION BECAUSE INVALID INPUT)
        assertThrows(RuntimeException.class, ()->{
            Main.program("a+, a, c, acc");
        });

        //INPUT 7 (THROWS EXCEPTION BECAUSE INVALID INPUT)
        assertThrows(RuntimeException.class, ()->{
            Main.program("a**, a, c, acc");
        });

        //INPUT 8 (THROWS EXCEPTION BECAUSE INVALID INPUT)
        assertThrows(RuntimeException.class, ()->{
            Main.program("");
        });

        //INPUT 9 (THROWS EXCEPTION BECAUSE INVALID INPUT)
        assertThrows(RuntimeException.class, ()->{
            Main.program("a");
        });

        //INPUT 10 (THROWS EXCEPTION BECAUSE INVALID INPUT)
        assertThrows(RuntimeException.class, ()->{
            Main.program("a, a, c, ");
        });

        //INPUT 11 (THROWS EXCEPTION BECAUSE INVALID INPUT)
        assertThrows(RuntimeException.class, ()->{
            Main.program(", a, c, a");
        });

        //INPUT 12 (THROWS EXCEPTION BECAUSE INVALID INPUT)
        assertThrows(RuntimeException.class, ()->{
            Main.program(", , , ,,");
        });

        //INPUT 13
        assertEquals("OK, OK, OK, OK, OK, OK, OK, OK, OK, OK, OK, KO",
                Main.program("a*(b+c)*(de)*f, f, af, bf, cf, def, aaaaaf, bbbbbf, ccccccf, bbbccccf, bbccbcbcbbbf, dededededef, df"));

        //INPUT 14
        assertEquals("KO, KO, KO, OK, KO, OK, OK, OK, OK, KO, OK",
                Main.program("1*(b+c)*(de)*F, ed, 1, P, 1F, f, 1bF, 1cF, 1bccbF, 1deF, 1dF, 1dedeF"));

        //INPUT 14
        assertEquals("OK, KO, KO, KO, KO, KO, KO",
                Main.program("abcd, abcd, a, b, c, d,ad,e"));

        //INPUT 15
        assertEquals("KO, OK, OK, OK, OK, KO, OK, KO, KO, OK",
                Main.program("a+b+c+d+(e+fg), abcd, a, b, c, d,ad,e,f,g,fg"));
    }
}