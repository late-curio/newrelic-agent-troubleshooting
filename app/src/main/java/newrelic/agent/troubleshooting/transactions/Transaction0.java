package newrelic.agent.troubleshooting.transactions;

import com.newrelic.api.agent.Trace;

public class Transaction0 implements Transaction {
    @Trace(dispatcher = true)
    public void startTransaction() {
        System.out.println("a transaction has been created!");
    }
}
