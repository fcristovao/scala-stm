package scala.concurrent.stm.stubs

import scala.concurrent.stm._
import scala.concurrent.stm.Ref._

class StubRef[A] extends Ref[A] {
	
	//from SourceLike[A]:
	def get(implicit txn: InTxn): A = throw new AbstractMethodError
	def getWith[Z](f: (A) => Z)(implicit txn: InTxn): Z = throw new AbstractMethodError
	def relaxedGet(equiv: (A, A) => Boolean)(implicit txn: InTxn): A = throw new AbstractMethodError 
	
	//from SinkLike[A]
	def set(v: A)(implicit txn: InTxn) = throw new AbstractMethodError
	def trySet(v: A)(implicit txn: InTxn): Boolean = throw new AbstractMethodError
	
	//from RefLike[A]
	def swap(v: A)(implicit txn: InTxn): A = throw new AbstractMethodError
	def transform(f: A => A)(implicit txn: InTxn) = throw new AbstractMethodError
	def transformIfDefined(pf: PartialFunction[A,A])(implicit txn: InTxn): Boolean = throw new AbstractMethodError
	
	//from Ref[A]
	def single: View[A] = throw new AbstractMethodError

}