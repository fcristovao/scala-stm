package scala.concurrent.stm.stubs

import scala.concurrent.stm._
import scala.concurrent.stm.impl.STMImpl
import scala.actors.threadpool.TimeUnit

class StubSTMImpl extends STMImpl with StubRefFactory with StubTxnContext with StubTxnExecutor{

	def newCommitBarrier(timeout: Long, unit: TimeUnit): CommitBarrier = throw new AbstractMethodError
}