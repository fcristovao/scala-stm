package scala.concurrent.stm.stubs

import scala.concurrent.stm._

trait StubTxnExecutor extends TxnExecutor {

	def apply[Z](block: InTxn => Z)(implicit mt: MaybeTxn): Z = throw new AbstractMethodError
  def oneOf[Z](blocks: (InTxn => Z)*)(implicit mt: MaybeTxn): Z = throw new AbstractMethodError
  def pushAlternative[Z](mt: MaybeTxn, block: InTxn => Z): Boolean = throw new AbstractMethodError
  def compareAndSet[A, B](a: Ref[A], a0: A, a1: A, b: Ref[B], b0: B, b1: B): Boolean = throw new AbstractMethodError
  def compareAndSetIdentity[A <: AnyRef, B <: AnyRef](a: Ref[A], a0: A, a1: A, b: Ref[B], b0: B, b1: B): Boolean = throw new AbstractMethodError
  def retryTimeoutNanos: Option[Long] = throw new AbstractMethodError
  def withRetryTimeoutNanos(timeout: Option[Long]): TxnExecutor = throw new AbstractMethodError
  def isControlFlow(x: Throwable): Boolean = throw new AbstractMethodError
  def withControlFlowRecognizer(pf: PartialFunction[Throwable, Boolean]): TxnExecutor = throw new AbstractMethodError
  def postDecisionFailureHandler: (Txn.Status, Throwable) => Unit = throw new AbstractMethodError
  def withPostDecisionFailureHandler(handler: (Txn.Status, Throwable) => Unit): TxnExecutor = throw new AbstractMethodError

}