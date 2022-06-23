package newrelic.agent.troubleshooting.transactions;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;

public class Transaction10 implements Transaction {

    @Trace(dispatcher = true)
    public void startTransaction() {
        System.out.println("newrelic.agent.troubleshooting.transactions.Transaction10: starting a transaction");

        Token token = NewRelic.getAgent().getTransaction().getToken();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                firstMethod(token);
            }
        });

        thread.start();
    }

    @Trace(dispatcher = true)
    private void firstMethod(Token token) {
        System.out.println("firstMethod");
        token.linkAndExpire();
    }
}
