package newrelic.agent.troubleshooting.transactions;

import com.newrelic.api.agent.Trace;

public class Transaction2 implements Transaction {

    @Trace(dispatcher = true)
    public void startTransaction() {
        System.out.println("newrelic.agent.troubleshooting.transactions.Transaction2: starting a transaction");
        firstMethod();
    }

    @Trace(async = true)
    private void firstMethod() {
        System.out.println("firstMethod");
    }
}
