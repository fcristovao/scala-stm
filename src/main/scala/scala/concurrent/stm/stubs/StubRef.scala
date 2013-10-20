package scala.concurrent.stm.stubs

import scala.concurrent.stm._
import scala.concurrent.stm.Ref._
import java.util.concurrent.TimeUnit

object StubRef {
	trait StubView[A] extends Ref.View[A] {
		//from Sink.View[A]
		def set(v: A) = throw new AbstractMethodError
		def trySet(v: A): Boolean = throw new AbstractMethodError

		//from Source.View[A]
		def get: A = throw new AbstractMethodError
		def getWith[Z](f: A => Z): Z = throw new AbstractMethodError
		def relaxedGet(equiv: (A, A) => Boolean): A = throw new AbstractMethodError
		def await(f: A => Boolean) = throw new AbstractMethodError
		def tryAwait(timeout: Long, unit: TimeUnit = TimeUnit.MILLISECONDS)(f: A => Boolean): Boolean = throw new AbstractMethodError

		//from Ref.View[A]
		override def ref: Ref[A] = throw new AbstractMethodError
		def swap(v: A): A = throw new AbstractMethodError
		def compareAndSet(before: A, after: A): Boolean = throw new AbstractMethodError
		def compareAndSetIdentity[B <: A with AnyRef](before: B, after: A): Boolean = throw new AbstractMethodError
		def transform(f: A => A) = throw new AbstractMethodError
		def getAndTransform(f: A => A): A = throw new AbstractMethodError
		def transformAndGet(f: A => A): A = throw new AbstractMethodError
		def transformIfDefined(pf: PartialFunction[A, A]): Boolean = throw new AbstractMethodError
	}
}

trait StubRef[A] extends Ref[A] {
	//from SourceLike[A]:
	def get(implicit txn: InTxn): A = throw new AbstractMethodError
	def getWith[Z](f: (A) => Z)(implicit txn: InTxn): Z = throw new AbstractMethodError
	def relaxedGet(equiv: (A, A) => Boolean)(implicit txn: InTxn): A = throw new AbstractMethodError

	//from SinkLike[A]
	def set(v: A)(implicit txn: InTxn): Unit = throw new AbstractMethodError
	def trySet(v: A)(implicit txn: InTxn): Boolean = throw new AbstractMethodError

	//from RefLike[A]
	def swap(v: A)(implicit txn: InTxn): A = throw new AbstractMethodError
	def transform(f: A => A)(implicit txn: InTxn) = throw new AbstractMethodError
	def transformIfDefined(pf: PartialFunction[A, A])(implicit txn: InTxn): Boolean = throw new AbstractMethodError

	//from Ref[A]
	def single: View[A] = throw new AbstractMethodError
}