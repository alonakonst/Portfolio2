import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        AdjacencyList adjgraph = new AdjacencyList();
        Vertex Eskildstrup = new Vertex("Eskildstrup");
        adjgraph.addVertex(Eskildstrup);
        Vertex Haslev = new Vertex("Haslev");
        adjgraph.addVertex(Haslev);
        Vertex Holbæk = new Vertex("Holbæk");
        adjgraph.addVertex(Holbæk);
        Vertex Jærgerspris = new Vertex("Jærgerspris");
        adjgraph.addVertex(Jærgerspris);
        Vertex Kalundborg = new Vertex("Kalundborg");
        adjgraph.addVertex(Kalundborg);
        Vertex Korsør = new Vertex("Korsør");
        adjgraph.addVertex(Korsør);
        Vertex Køge = new Vertex("køge");
        adjgraph.addVertex(Køge);
        Vertex Maribo = new Vertex("Maribo");
        adjgraph.addVertex(Maribo);
        Vertex Næstved = new Vertex("Næstved");
        adjgraph.addVertex(Næstved);
        Vertex Ringsted = new Vertex("Ringsted");
        adjgraph.addVertex(Ringsted);
        Vertex Slagelse = new Vertex("Slagelse");
        adjgraph.addVertex(Slagelse);
        Vertex Sorø = new Vertex("Sorø");
        adjgraph.addVertex(Sorø);
        Vertex Vordingborg = new Vertex("Vordingborg");
        adjgraph.addVertex(Vordingborg);
        Vertex Roskilde = new Vertex("Roskilde");
        adjgraph.addVertex(Roskilde);
        Vertex Nykøbing_F = new Vertex("Nykøbing F");
        adjgraph.addVertex(Nykøbing_F);
        Vertex Nakskov = new Vertex("Nakskov");
        adjgraph.addVertex(Nakskov);

        adjgraph.newEdge(Eskildstrup, Maribo, 28);
        adjgraph.newEdge(Eskildstrup, Nykøbing_F, 13);
        adjgraph.newEdge(Eskildstrup, Vordingborg, 24);

        adjgraph.newEdge(Haslev, Korsør, 60);
        adjgraph.newEdge(Haslev, Køge, 24);
        adjgraph.newEdge(Haslev, Næstved, 25);
        adjgraph.newEdge(Haslev, Ringsted, 19);
        adjgraph.newEdge(Haslev, Roskilde, 47);
        adjgraph.newEdge(Haslev, Slagelse, 48);
        adjgraph.newEdge(Haslev, Sorø, 34);

        adjgraph.newEdge(Holbæk, Jærgerspris, 34);
        adjgraph.newEdge(Holbæk, Kalundborg, 44);
        adjgraph.newEdge(Holbæk, Korsør, 66);
        adjgraph.newEdge(Holbæk, Ringsted, 36);
        adjgraph.newEdge(Holbæk, Roskilde, 32);
        adjgraph.newEdge(Holbæk, Slagelse, 46);
        adjgraph.newEdge(Holbæk, Sorø, 34);

        adjgraph.newEdge(Jærgerspris, Korsør, 95);
        adjgraph.newEdge(Jærgerspris, Køge, 58);
        adjgraph.newEdge(Jærgerspris, Ringsted, 56);
        adjgraph.newEdge(Jærgerspris, Roskilde, 33);
        adjgraph.newEdge(Jærgerspris, Slagelse, 74);
        adjgraph.newEdge(Jærgerspris, Sorø, 63);
        adjgraph.newEdge(Jærgerspris, Holbæk, 34);

        adjgraph.newEdge(Kalundborg, Ringsted, 62);
        adjgraph.newEdge(Kalundborg, Roskilde, 70);
        adjgraph.newEdge(Kalundborg, Slagelse, 39);
        adjgraph.newEdge(Kalundborg, Sorø, 51);
        adjgraph.newEdge(Kalundborg, Holbæk, 44);

        adjgraph.newEdge(Korsør, Næstved, 45);
        adjgraph.newEdge(Korsør, Slagelse, 20);
        adjgraph.newEdge(Korsør, Jærgerspris, 95);
        adjgraph.newEdge(Korsør, Holbæk, 66);
        adjgraph.newEdge(Korsør, Haslev, 60);

        adjgraph.newEdge(Køge, Næstved, 45);
        adjgraph.newEdge(Køge, Ringsted, 28);
        adjgraph.newEdge(Køge, Roskilde, 25);
        adjgraph.newEdge(Køge, Vordingborg, 60);
        adjgraph.newEdge(Køge, Jærgerspris, 58);
        adjgraph.newEdge(Køge, Haslev, 24);

        adjgraph.newEdge(Maribo, Nakskov, 27);
        adjgraph.newEdge(Maribo, Nykøbing_F, 26);
        adjgraph.newEdge(Maribo, Eskildstrup, 28);

        adjgraph.newEdge(Næstved, Roskilde, 57);
        adjgraph.newEdge(Næstved, Ringsted, 26);
        adjgraph.newEdge(Næstved, Slagelse, 37);
        adjgraph.newEdge(Næstved, Sorø, 32);
        adjgraph.newEdge(Næstved, Vordingborg, 28);
        adjgraph.newEdge(Næstved, Køge, 45);
        adjgraph.newEdge(Næstved, Korsør, 45);
        adjgraph.newEdge(Næstved, Haslev, 25);

        adjgraph.newEdge(Ringsted, Roskilde, 31);
        adjgraph.newEdge(Ringsted, Sorø, 15);
        adjgraph.newEdge(Ringsted, Vordingborg, 58);
        adjgraph.newEdge(Ringsted, Næstved, 26);
        adjgraph.newEdge(Ringsted, Køge, 28);
        adjgraph.newEdge(Ringsted, Kalundborg, 62);
        adjgraph.newEdge(Ringsted, Jærgerspris, 56);
        adjgraph.newEdge(Ringsted, Holbæk, 36);
        adjgraph.newEdge(Ringsted, Haslev, 19);

        adjgraph.newEdge(Slagelse, Sorø, 14);
        adjgraph.newEdge(Slagelse, Næstved, 37);
        adjgraph.newEdge(Slagelse, Korsør, 20);
        adjgraph.newEdge(Slagelse, Kalundborg, 39);
        adjgraph.newEdge(Slagelse, Jærgerspris, 74);
        adjgraph.newEdge(Slagelse, Holbæk, 46);
        adjgraph.newEdge(Slagelse, Haslev, 48);

        adjgraph.newEdge(Sorø, Slagelse, 14);
        adjgraph.newEdge(Sorø, Ringsted, 15);
        adjgraph.newEdge(Sorø, Næstved, 32);
        adjgraph.newEdge(Sorø, Kalundborg, 51);
        adjgraph.newEdge(Sorø, Jærgerspris, 63);
        adjgraph.newEdge(Sorø, Holbæk, 34);
        adjgraph.newEdge(Sorø, Haslev, 34);

        adjgraph.newEdge(Vordingborg, Ringsted, 58);
        adjgraph.newEdge(Vordingborg, Næstved, 28);
        adjgraph.newEdge(Vordingborg, Køge, 60);
        adjgraph.newEdge(Vordingborg, Eskildstrup, 24);
        adjgraph.newEdge(Vordingborg, Haslev, 40);

        adjgraph.newEdge(Roskilde, Ringsted, 31);
        adjgraph.newEdge(Roskilde, Næstved, 57);
        adjgraph.newEdge(Roskilde, Køge, 25);
        adjgraph.newEdge(Roskilde, Kalundborg, 70);
        adjgraph.newEdge(Roskilde, Jærgerspris, 33);
        adjgraph.newEdge(Roskilde, Holbæk, 32);
        adjgraph.newEdge(Roskilde, Haslev, 47);

        adjgraph.newEdge(Nykøbing_F, Maribo, 26);
        adjgraph.newEdge(Nykøbing_F, Eskildstrup, 13);

        adjgraph.newEdge(Nakskov, Maribo, 27);

        adjgraph.MSTPrims();

    }
}


