package newrelic.agent.troubleshooting.transactions;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;

public class Transaction14 implements Transaction {

    @Trace(dispatcher = true)
    public void startTransaction() {
        System.out.println("newrelic.agent.troubleshooting.transactions.Transaction14: starting a transaction");

        Token token = NewRelic.getAgent().getTransaction().getToken();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                firstMethod(token);
            }
        });

        thread.start();
    }

    @Trace(async = true)
    private void firstMethod(Token token) {
        System.out.println("firstMethod");
        Token secondToken = NewRelic.getAgent().getTransaction().getToken();
        token.linkAndExpire();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                secondMethod(secondToken);
            }
        });

        thread2.start();
    }

    @Trace(async = true)
    private void secondMethod(Token token) {
        System.out.println("secondMethod");
        token.linkAndExpire();
    }
}
