package newrelic.agent.troubleshooting.transactions;

import com.newrelic.api.agent.Trace;

public class Transaction3 implements Transaction {

    @Trace(async = true)
    public void startTransaction() {
        System.out.println("newrelic.agent.troubleshooting.transactions.Transaction3: starting a transaction");
        firstMethod();
    }

    @Trace
    private void firstMethod() {
        System.out.println("firstMethod");
    }
}
