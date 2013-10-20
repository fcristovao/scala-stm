package scala.concurrent.stm.stubs

import scala.concurrent.stm._

trait StubInTxn extends InTxn{
	import scala.concurrent.stm.Txn._

  // The user-visible versions of these methods are in the Txn object.

  def status: Status = throw new AbstractMethodError
  def rootLevel: NestingLevel = throw new AbstractMethodError
  def currentLevel: NestingLevel = throw new AbstractMethodError
  def rollback(cause: RollbackCause): Nothing = throw new AbstractMethodError
  def retry(): Nothing = throw new AbstractMethodError
  def retryFor(timeoutNanos: Long) = throw new AbstractMethodError
  def beforeCommit(handler: InTxn => Unit) = throw new AbstractMethodError
  def whilePreparing(handler: InTxnEnd => Unit) = throw new AbstractMethodError
  def whileCommitting(handler: InTxnEnd => Unit) = throw new AbstractMethodError
  def afterCommit(handler: Status => Unit) = throw new AbstractMethodError
  def afterRollback(handler: Status => Unit) = throw new AbstractMethodError
  def afterCompletion(handler: Status => Unit) = throw new AbstractMethodError
  def setExternalDecider(decider: ExternalDecider) = throw new AbstractMethodError
}