package gnu.trove;

import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.lists.TUnmodifiableIntLists;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.maps.TUnmodifiableIntObjectMaps;
import gnu.trove.set.TIntSet;
import gnu.trove.set.hash.TIntHashSet;
import gnu.trove.sets.TUnmodifiableIntSets;
import junit.framework.TestCase;


/**
 *
 */
public class TCollectionsTest extends TestCase {
	public void testUnmodifiableList() {
		final TIntArrayList one = new TIntArrayList( new int[]{ 1, 2, 3, 4 } );
		final TIntArrayList two = new TIntArrayList( new int[]{ 1, 2, 3, 4 } );
		TIntList uOne = TUnmodifiableIntLists.wrap( one );
		TIntList uTwo = TUnmodifiableIntLists.wrap( two );

		assertEquals( one, two );
		assertEquals( uOne, uTwo );
		assertEquals( one, uTwo );
		assertEquals( uOne, two );
	}


	public void testUnmodifiableSet() {
		final TIntSet one = new TIntHashSet( new int[]{ 1, 2, 3, 4 } );
		final TIntSet two = new TIntHashSet( new int[]{ 1, 2, 3, 4 } );
		TIntSet uOne = TUnmodifiableIntSets.wrap( one );
		TIntSet uTwo = TUnmodifiableIntSets.wrap( two );

		assertEquals( one, two );
		assertEquals( uOne, uTwo );
	}


	public void testUnmodifiableMap() {
		final TIntObjectMap<Integer> one = new TIntObjectHashMap<Integer>();
		one.put( 0, Integer.valueOf( 0 ) );
		one.put( 1, Integer.valueOf( 1 ) );
		one.put( 2, Integer.valueOf( 2 ) );
		one.put( 3, Integer.valueOf( 3 ) );
		final TIntObjectMap<Integer> two = new TIntObjectHashMap<Integer>( one );
		TIntObjectMap<Integer> uOne = TUnmodifiableIntObjectMaps.wrap( one );
		TIntObjectMap<Integer> uTwo = TUnmodifiableIntObjectMaps.wrap( two );

		assertEquals( one, two );
		assertEquals( uOne, uTwo );
	}
}
