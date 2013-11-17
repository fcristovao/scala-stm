package scala.concurrent.stm.stubs

import scala.concurrent.stm._
import scala.concurrent.stm.impl.STMImpl
import java.util.concurrent.TimeUnit

trait StubSTMImpl extends StubTxnExecutor with STMImpl with StubRefFactory with StubTxnContext {
	def newCommitBarrier(timeout: Long, unit: TimeUnit): CommitBarrier = throw new AbstractMethodError
}