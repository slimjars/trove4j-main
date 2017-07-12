///////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2017, Sebastian Kuerten All Rights Reserved.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
///////////////////////////////////////////////////////////////////////////////

package gnu.trove.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import gnu.trove.list.TIntList;
import junit.framework.TestCase;


public abstract class TPrimitiveListBinarySearchTest extends TestCase {

    protected abstract TIntList list();


    private TIntList list;
    private List<Integer> sList;

    private void init() {
        list = list();
        sList = new ArrayList<>();
    }

    public void testContiguous() {
        for ( int i = 1; i <= 100; i++ ) {
            init();
            testContiguous( i );
        }
    }


    private void testContiguous( int count ) {

        // index: 0, 1, 2, 3, ..., count
        // value: 0, 1, 2, 3, ..., count

        for ( int i = 0; i < count; i++ ) {
            list.add( i );
            sList.add( i );
        }

        for ( int i = 0; i < count; i++ ) {
            int index = list.binarySearch( i );
            int sIndex = Collections.binarySearch( sList, i );
            assertEquals( i, index );
            assertEquals( sIndex, index );
        }
    }


    public void testStepped() {
        for ( int i = 1; i <= 100; i++ ) {
            init();
            testStepped( i );
        }
    }

    private void testStepped( int count ) {

        // index: 0, 1, 2, 3, ..., count
        // value: 0, 2, 4, 6, ..., count * 2

        // for the examples below, assume count = 4:
        // index: 0, 1, 2, 3
        // value: 0, 2, 4, 6

        for ( int i = 0; i < count; i++ ) {
            list.add( i * 2 );
            sList.add( i * 2 );
        }

        // check all values that are contained in the list
        // example: check 0, 2, 4, 6
        for ( int i = 0; i < count; i++ ) {
            int index = list.binarySearch( i * 2 );
            int sIndex = Collections.binarySearch( sList, i * 2 );
            assertEquals( i, index );
            assertEquals( sIndex, index );
        }

        // check all missing values in between
        // example: check 1, 3, 5
        for ( int i = 0; i < count - 1; i++ ) {
            int index = list.binarySearch( i * 2 + 1 );
            int sIndex = Collections.binarySearch( sList, i * 2 + 1 );
            assertEquals( -i - 2, index );
            assertEquals( sIndex, index );
        }

        // check -1 and ((count - 1) * 2 + 1)
        // example: check -1 and 7
        {
            int i = -1;
            int index = list.binarySearch( i * 2 + 1 );
            int sIndex = Collections.binarySearch( sList, i * 2 + 1 );
            assertEquals( -1, index );
            assertEquals( sIndex, index );
        }
        {
            int i = count - 1;
            int index = list.binarySearch( i * 2 + 1 );
            int sIndex = Collections.binarySearch( sList, i * 2 + 1 );
            assertEquals( -count - 1, index );
            assertEquals( sIndex, index );
        }
    }


    /*
     * Build random test cases that can be verified using
     * Collections.binarySearch (no duplicates, because it is not defined which
     * duplicate's index will be returned by a search)
     */

    public void testRandom() {
        for ( int i = 1; i <= 100; i++ ) {
            init();
            testRandom( 0, i, 5 );
        }
    }

    private void testRandom( int seed, int count, int maxGap ) {
        Random r = new Random( seed );

        int value = 0;

        for ( int i = 0; i < count; i++ ) {
            value += 1 + r.nextInt( maxGap );
            list.add( value );
            sList.add( value );
        }

        int min = list.min();
        int max = list.max();

        for ( int i = min - 1; i <= max + 1; i++ ) {
            int index = list.binarySearch( i );
            int sIndex = Collections.binarySearch( sList, i );
            assertEquals( sIndex, index );
        }
    }

}
