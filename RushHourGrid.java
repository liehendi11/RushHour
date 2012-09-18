/*
 *  RushHourGrid.h
 *  RealTimeSearch
 *
 */

import java.util.ArrayList;

class RushHourGrid
{

    // Private
    private char[] m_data;
    private int    m_width;
    private int    m_height;
    private int    m_size;

    private void setDimension( int width, int height )
	{
        m_width  = width;
        m_height = height;
        m_size   = width * height;
        m_data = new char[m_size];
        for (int i=0; i<m_size; ++i ) {
           m_data[i] = FREE;
        }
    }


    // Public
    public static final char FREE         = ' ';    // SPACE CHARACTER  " "
    public static final char BLOCKED      = '#';    // WALL CHARACTER   "#"
    public static final char EXIT         = '=';    // WALL EXIT CHAR   "="
    public static final char FIRST_LETTER = 'A';    // CHAR "A"
    public static final char LAST_LETTER  = 'U';    // CHAR "U" .. between A and U are 21 letters

    public RushHourGrid( int width, int height )
    {
        setDimension( width, height );
    }


    public int getHeight()
    {
        return m_height;
    }


    public int getWidth()
    {
        return m_width;
    }


    public char getAt( int col, int row )
	{
        return m_data[m_width * row + col];
    }


    public int getAt( int i )
	{
        return m_data[i];
    }


    public void setAt( int col, int row, char value )
	{
        m_data[m_width * row + col] = value;
    }


    public void setAt( int i, char value )
	{
        m_data[i] = value;
    }


    public boolean isFree( int col, int row )
	{
        return (getAt( col, row ) == FREE);
    }


    public boolean isExit( int col, int row )
    {
        return (getAt(col, row) == EXIT); 
    }


    public boolean isCar( int col, int row )
    {
        return (getAt( col, row) >= FIRST_LETTER && getAt( col, row) <= LAST_LETTER );
    }


    public RushHourGrid merge( ArrayList<RushHourCar> cars )
    {
        RushHourGrid tgrid = this.clone();

        for( int i = 0; i<cars.size(); ++i )
        {
            RushHourCar c = cars.get(i);
            for(int j = 0; j<c.getLength(); ++j)
            {
                int tr = c.getHead().getRow();
                int tc = c.getHead().getCol();
                if( c.getOrientation() == RushHourCar.Orientation.VERTICAL )
                    tr += j;
                else if( c.getOrientation() == RushHourCar.Orientation.HORIZONTAL )
                    tc += j;
                tgrid.setAt(tc, tr, (char)(c.getCarId()+RushHourGrid.FIRST_LETTER) );
            }
        }
        return tgrid;
    }


    public void draw( ArrayList<RushHourCar> cars )
    {
        if( m_data == null )
        {
            System.out.println("The grid must be initialized first.");
            System.exit( -20 );
        }

        // Add all the cars to the temp grid and then draw (simpler)
        RushHourGrid tgrid = merge( cars );

        System.out.println();

        // Draw the entire grid
        for( int c = 0; c < tgrid.getHeight(); c++ )
        {
            for( int r = 0; r < tgrid.getWidth(); r++ )
            {
                System.out.print( tgrid.getAt( r, c ) );
            }
            System.out.println();
        }

    }

	public RushHourGrid clone()
	{
        RushHourGrid grid = new RushHourGrid( m_width, m_height );
        for (int i=0; i<m_size; ++i ) {
            grid.setAt( i, m_data[i] );
        }
        return grid;
    }

}
