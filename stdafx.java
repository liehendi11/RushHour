
// Action int
// Cost int
// StateID long
// ActionList ArrayList


/*
class LongLongHash
{
	 operator()(unsigned long long x) const
	{ return size_t(x) + size_t(x >> 22) * 5 + size_t(x >> 43);	}

	Boolean operator()(unsigned long long x1, unsigned long long x2) const
	{ return x1 < x2; }
};
*/

class StateID
{
    long value;

    StateID() {
        value = 0;
    }
}

class Action
{
    // empty
    String toStr() { return "<empty>"; };
}

class Cost
{
    int value;
}

class GridPos
{
	private int m_row;
	private int m_col;
	
	GridPos() {
        m_row = -1;
        m_col = -1;
    }
	
	GridPos( int c, int r ) {
        m_row = r;
        m_col = c;
    }
    
    void set( GridPos pos ) {
        m_col = pos.getCol();
        m_row = pos.getRow();
    }

    void set( int col, int row ) {
        m_col = col;
        m_row = row;
    }

    void setRow( int row ) {
        m_row = row;
    }

    void setCol( int col ) {
        m_col = col;
    }

    int getRow() {
        return m_row;
    }

    int getCol() {
        return m_col;
    }
}
