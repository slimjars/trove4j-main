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

package gnu.trove.list.array;

import gnu.trove.list.TIntList;
import gnu.trove.list.TPrimitiveListBinarySearchTest;


public class TPrimitiveArrayListBinarySearchTest extends TPrimitiveListBinarySearchTest {

    protected TIntList list() {
        return new TIntArrayList();
    }

}
