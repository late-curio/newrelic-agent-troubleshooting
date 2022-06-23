package newrelic.agent.troubleshooting.transactions;

import com.newrelic.api.agent.Trace;

public class Transaction1 implements Transaction {

    @Trace(dispatcher = true)
    public void startTransaction() {
        System.out.println("newrelic.agent.troubleshooting.transactions.Transaction1: starting a transaction");
        firstMethod();
    }

    @Trace(dispatcher = true)
    private void firstMethod() {
        System.out.println("firstMethod");
    }
}
