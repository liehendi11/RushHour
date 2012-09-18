//
// RushHour Action
//
import java.util.*;

class RushHourAction extends Action
{
    private int m_carid;   // The id of the car that is to be moved
    private int m_moveby;  // How much this car should be moved by
                           // (each car knows how he is orientated so this is simply a
                           // negative number for down/left or a positive number for up/right)

    RushHourAction( int cid, int mby )
    {
        m_carid = cid;
        m_moveby = mby;
    }

    int getCarId()
    {
        return m_carid;
    }

    int getMoveBy()
    {
        return m_moveby;
    }

    String toStr()
    {
        String str;
        str = "" + (char)(m_carid + RushHourGrid.FIRST_LETTER);
        if ( m_moveby >= 0 ) {
           str += '+';
        }
        str += m_moveby;

        return str;
    }
}
