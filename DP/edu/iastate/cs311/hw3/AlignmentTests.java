package edu.iastate.cs311.hw3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Test;

public class AlignmentTests {
	private static String generateString(int clen) {
		Random rand = new Random();
		char[] base = { 'A', 'C', 'G', 'T' };
		char[] carr = new char[clen];
		for (int k = 0; k < clen; k++) {
			int num = rand.nextInt(4);
			carr[k] = base[num];
		}
		return new String(carr);
	}
	
	@Test
	public void simpleTest() {
		SubstitutionGap param = new SubstitutionGap();
		Sequence seqone = new Sequence("A", "AAAACCCCAGCT");
		Sequence seqtwo = new Sequence("B", "CCCCAAAATGCT");
		Alignment align = new Alignment(seqone, seqtwo, param);

		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
		System.out.println(align.getEditdistance() + " " + align.getMinColumnWiseSum());
	}

	@Test
    public void test1() {
    	SubstitutionGap param = new SubstitutionGap();
        Sequence seqone = new Sequence("A", generateString(10));
        Sequence seqtwo = new Sequence("B", generateString(10));
        Alignment align = new Alignment(seqone, seqtwo, param);
        
		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
    }
	
	@Test
    public void test2() {
    	SubstitutionGap param = new SubstitutionGap();
        Sequence seqone = new Sequence("A", generateString(20));
        Sequence seqtwo = new Sequence("B", generateString(10));
        Alignment align = new Alignment(seqone, seqtwo, param);
        
		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
    }
	
	@Test
    public void test3() {
    	SubstitutionGap param = new SubstitutionGap();
        Sequence seqone = new Sequence("A", generateString(10));
        Sequence seqtwo = new Sequence("B", generateString(100));
        Alignment align = new Alignment(seqone, seqtwo, param);
        
		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
    }
	
	@Test
    public void test4() {
    	SubstitutionGap param = new SubstitutionGap();
        Sequence seqone = new Sequence("A", generateString(100));
        Sequence seqtwo = new Sequence("B", generateString(100));
        Alignment align = new Alignment(seqone, seqtwo, param);
        
		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
    }
	
	@Test
    public void test5() {
    	SubstitutionGap param = new SubstitutionGap();
        Sequence seqone = new Sequence("A", generateString(250));
        Sequence seqtwo = new Sequence("B", generateString(300));
        Alignment align = new Alignment(seqone, seqtwo, param);
        
		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
    }
	
	@Test
    public void test6() {
    	SubstitutionGap param = new SubstitutionGap();
        Sequence seqone = new Sequence("A", generateString(500));
        Sequence seqtwo = new Sequence("B", generateString(500));
        Alignment align = new Alignment(seqone, seqtwo, param);
        
		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
    }
	
	@Test
    public void test7() {
    	SubstitutionGap param = new SubstitutionGap();
        Sequence seqone = new Sequence("A", generateString(1000));
        Sequence seqtwo = new Sequence("B", generateString(1100));
        Alignment align = new Alignment(seqone, seqtwo, param);
        
		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
    }
	
	@Test
    public void test8() {
    	SubstitutionGap param = new SubstitutionGap();
        Sequence seqone = new Sequence("A", generateString(2410));
        Sequence seqtwo = new Sequence("B", generateString(2110));
        Alignment align = new Alignment(seqone, seqtwo, param);
        
		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
    }
	
	@Test
    public void test9() {
    	SubstitutionGap param = new SubstitutionGap();
        Sequence seqone = new Sequence("A", generateString(4096));
        Sequence seqtwo = new Sequence("B", generateString(4096));
        Alignment align = new Alignment(seqone, seqtwo, param);
        
		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
    }
	
	@Test
    public void test10() {
    	SubstitutionGap param = new SubstitutionGap();
        Sequence seqone = new Sequence("A", generateString(5000));
        Sequence seqtwo = new Sequence("B", generateString(5000));
        Alignment align = new Alignment(seqone, seqtwo, param);
        
		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
		System.out.println(align.getEditdistance() + " " + align.getMinColumnWiseSum());
    }
	
	@Test
    public void test11() {
    	SubstitutionGap param = new SubstitutionGap();
        Sequence seqone = new Sequence("A", generateString(100));
        Sequence seqtwo = new Sequence("B", generateString(0));
        Alignment align = new Alignment(seqone, seqtwo, param);
        
		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
    }
	
	@Test
    public void test12() {
    	SubstitutionGap param = new SubstitutionGap();
        Sequence seqone = new Sequence("A", generateString(0));
        Sequence seqtwo = new Sequence("B", generateString(100));
        Alignment align = new Alignment(seqone, seqtwo, param);
        
		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
    }
	
	@Test
    public void test13() {
    	SubstitutionGap param = new SubstitutionGap();
        Sequence seqone = new Sequence("A", generateString(1100));
        Sequence seqtwo = new Sequence("B", generateString(10));
        Alignment align = new Alignment(seqone, seqtwo, param);
        
		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
    }
	
	@Test
    public void test14() {
    	SubstitutionGap param = new SubstitutionGap();
        Sequence seqone = new Sequence("A", generateString(25));
        Sequence seqtwo = new Sequence("B", generateString(5000));
        Alignment align = new Alignment(seqone, seqtwo, param);
        
		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
    }
	
	@Test
    public void test15() {
    	SubstitutionGap param = new SubstitutionGap();
        Sequence seqone = new Sequence("A", generateString(1));
        Sequence seqtwo = new Sequence("B", generateString(1000));
        Alignment align = new Alignment(seqone, seqtwo, param);
        
		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
    }
	
	@Test
    public void test16() {
    	SubstitutionGap param = new SubstitutionGap();
        Sequence seqone = new Sequence("A", generateString(10000));
        Sequence seqtwo = new Sequence("B", generateString(10000));
        Alignment align = new Alignment(seqone, seqtwo, param);
        
		assertEquals(align.getEditdistance(), align.getMinColumnWiseSum());
		System.out.println(align.getEditdistance() + " " + align.getMinColumnWiseSum());
    }
}

