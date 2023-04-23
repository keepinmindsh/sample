package bong.lines.sample;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="member_seq_generator", sequenceName = "member_seq", allocationSize = 1)
public class ㅁMemberForSeq {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long id;

    @Column(nullable = false, length = 500, unique = false, name = "name")
    private String name;

    public Long getId() {
        return id;
    }Container(
            padding: const EdgeInsets.all(10.0),
    child: ListView.builder(
    shrinkWrap: true,
    itemCount: _messages.length,
    itemBuilder: (BuildContext context, int i) {
        var message = _messages[i];

        return ListTile(
                title: Text('${message.sender} [${message.date}]'),
                subtitle: Text('${message.body}'),
              );
    },
            ),
            )

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
