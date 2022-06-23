package newrelic.agent.troubleshooting.transactions;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;

public class Transaction12 implements Transaction {

    @Trace(dispatcher = true)
    public void startTransaction() {
        System.out.println("newrelic.agent.troubleshooting.transactions.Transaction12: starting a transaction");

        Token token = NewRelic.getAgent().getTransaction().getToken();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                firstMethod(token);
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                secondMethod(token);
            }
        });

        thread2.start();
    }

    @Trace(async = true)
    private void firstMethod(Token token) {
        System.out.println("firstMethod");
        token.link();
    }

    @Trace(async = true)
    private void secondMethod(Token token) {
        System.out.println("secondMethod");
        token.linkAndExpire();
    }
}
