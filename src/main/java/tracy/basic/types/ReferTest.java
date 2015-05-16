package tracy.basic.types;

/**
 * User: tracy
 * Time: 2015/5/16 14:55
 */
public class ReferTest {
        public static void main(String [] args)
        {
            ReferTest x = new ReferTest();		/* Line 5*/
            ReferTest x2 = m1(x);
            ReferTest x4 = new ReferTest();		/* Line 7 */
            x2 = x4;			/* Line 8 */
            // do other stuffs
        }
        static ReferTest m1(ReferTest mx)
        {
            mx = new ReferTest();		/* Line 13 */
            return mx;
        }

}
