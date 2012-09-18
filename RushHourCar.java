/*
 *  RushHourCar.h
 *  RealTimeSearch
 *
 *  Created by Sverrir Sigmundarson on 25.1.2006.
 *  Copyright 2006 Reykjavik University. All rights reserved.
 *
 */

import java.lang.Object;

class RushHourCar
{
    public enum Orientation { VERTICAL, HORIZONTAL }
    
    private int         m_carid;       // The unique id of this car
    private Orientation m_orientation; // The orientation of the car on the board (1=vertical, 2=horizontal)
    private int         m_length;
    private GridPos     m_head;        // The head position of the car
    
    RushHourCar( int cid )
    {
        m_carid = cid;
        m_orientation = Orientation.VERTICAL;
        m_length = 0;
        m_head = new GridPos();
    }


    int getCarId()
    {
        return m_carid;
    }

    Orientation getOrientation()
    {
        return m_orientation;
    }

    int getLength()
    {
        return m_length;
    }

    GridPos getHead()
    {
        return m_head;
    }
    
    void setHead( GridPos pos )
    {
        m_head.set( pos );
    }
    
    void setOrientation( int col, int row )
    {
        if( m_head.getRow() == -1 )
        {
            m_head.set( col, row );
        }
        else
        {
            // The rows are the same, the car is horizontal
            if( m_head.getRow() - row == 0 )
            {
                m_orientation = Orientation.HORIZONTAL;
                m_length = (col - m_head.getCol())+1;
            }
            else if( m_head.getCol() - col == 0 )
            {
                m_orientation = Orientation.VERTICAL;
                m_length = (row - m_head.getRow())+1;
            }
            else
            {
                System.out.println("ERROR: the orientation data is wrong for the car, checke the .rh puzzle file");
                System.exit(-99);
            }
        }
    }
    
    void move( int distance )
    {
        if( m_orientation == Orientation.HORIZONTAL ) // Horizontal
            m_head.setCol( m_head.getCol() + distance );
        else if( m_orientation == Orientation.VERTICAL ) // Vertical
            m_head.setRow( m_head.getRow() + distance );
        else
            System.out.println("Error: Car.move(), orientation is not set correctly");
    }
};
