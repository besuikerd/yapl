package yapl.utils;

/**
 * class that represents a 2-tuple
 * @author Nicker
 *
 * @param <A>
 * @param <B>
 */
public class Tuple2<A, B> {
	public final A _1;
	public final B _2;
	
	public Tuple2(A a, B b) {
		this._1 = a;
		this._2 = b;
	}
}
