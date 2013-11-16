package scala.concurrent.stm.stubs

import scala.concurrent.stm._
import scala.concurrent.stm.impl.TxnContext

trait StubTxnContext extends TxnContext {
	def findCurrent(implicit mt: MaybeTxn): Option[InTxn] = throw new AbstractMethodError
	def dynCurrentOrNull: InTxn = throw new AbstractMethodError
}