package newrelic.agent.troubleshooting.transactions;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Segment;
import com.newrelic.api.agent.Trace;

public class Transaction18 implements Transaction {

    @Trace(dispatcher = true)
    public void startTransaction() {
        System.out.println("newrelic.agent.troubleshooting.transactions.Transaction18: starting a transaction");

        firstMethod();
    }

    @Trace
    private void firstMethod() {
        System.out.println("firstMethod");
        Segment firstSegment = NewRelic.getAgent().getTransaction().startSegment("firstSegment");
        secondMethod();
        firstSegment.end();
    }

    @Trace
    private void secondMethod() {
        System.out.println("secondMethod");
        Segment secondSegment = NewRelic.getAgent().getTransaction().startSegment("secondSegment");
        secondSegment.end();
    }
}
