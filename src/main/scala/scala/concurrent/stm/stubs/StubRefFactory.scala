package scala.concurrent.stm.stubs

import scala.concurrent.stm._
import scala.concurrent.stm.impl.RefFactory
import scala.collection.mutable.Builder

trait StubRefFactory extends RefFactory {

	def newRef(v0: Boolean): Ref[Boolean] = throw new AbstractMethodError
	def newRef(v0: Byte): Ref[Byte] = throw new AbstractMethodError
	def newRef(v0: Short): Ref[Short] = throw new AbstractMethodError
	def newRef(v0: Char): Ref[Char] = throw new AbstractMethodError
	def newRef(v0: Int): Ref[Int] = throw new AbstractMethodError
	def newRef(v0: Float): Ref[Float] = throw new AbstractMethodError
	def newRef(v0: Long): Ref[Long] = throw new AbstractMethodError
	def newRef(v0: Double): Ref[Double] = throw new AbstractMethodError
	def newRef(v0: Unit): Ref[Unit] = throw new AbstractMethodError
	def newRef[A: ClassManifest](v0: A): Ref[A] = throw new AbstractMethodError

	def newTxnLocal[A](
		init: => A,
		initialValue: InTxn => A,
		beforeCommit: InTxn => Unit,
		whilePreparing: InTxnEnd => Unit,
		whileCommitting: InTxnEnd => Unit,
		afterCommit: A => Unit,
		afterRollback: Txn.Status => Unit,
		afterCompletion: Txn.Status => Unit): TxnLocal[A] = throw new AbstractMethodError

	def newTArray[A: ClassManifest](length: Int): TArray[A] = throw new AbstractMethodError
	def newTArray[A: ClassManifest](xs: TraversableOnce[A]): TArray[A] = throw new AbstractMethodError

	def newTMap[A, B]: TMap[A, B] = throw new AbstractMethodError
	def newTMapBuilder[A, B]: Builder[(A, B), TMap[A, B]] = throw new AbstractMethodError

	def newTSet[A]: TSet[A] = throw new AbstractMethodError
	def newTSetBuilder[A]: Builder[A, TSet[A]] = throw new AbstractMethodError

}