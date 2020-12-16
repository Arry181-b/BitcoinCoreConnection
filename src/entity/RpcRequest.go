package entity


/**
  * {
     “id":编号,
     "method":功能方法或命令
     "jsonrpc":"rpc版本2.0"
     "params":[携带的参数，组成形式]
     }
*/
type RPCRequest struct {
	Id int64	 			`json:"id"`
	Method string			`json:"method"`
	Jsonrpc string			`json:"jsonrpc"`
	Params []interface{}	`json:"params"`
}
