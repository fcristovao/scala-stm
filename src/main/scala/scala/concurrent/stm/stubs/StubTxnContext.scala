package scala.concurrent.stm.stubs

import scala.concurrent.stm._
import scala.concurrent.stm.impl.TxnContext

trait StubTxnContext extends TxnContext {
	def findCurrent(implicit mt: MaybeTxn): Option[InTxn] = {
		mt match {
			case TxnUnknown => {
				dynCurrentOrNull match {
					case null => None
					case txn => Some(txn)
				}
			}
			case txn: InTxn => Some(txn)
		}
	}
	def dynCurrentOrNull: InTxn = throw new AbstractMethodError
}