package newrelic.agent.troubleshooting.transactions;

import com.newrelic.api.agent.Trace;

public class Transaction7 implements Transaction {

    @Trace(dispatcher = true)
    public void startTransaction() {
        System.out.println("newrelic.agent.troubleshooting.transactions.Transaction7: starting a transaction");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                firstMethod();
            }
        });

        thread.start();
    }

    @Trace(dispatcher = true)
    private void firstMethod() {
        System.out.println("firstMethod");
    }
}
