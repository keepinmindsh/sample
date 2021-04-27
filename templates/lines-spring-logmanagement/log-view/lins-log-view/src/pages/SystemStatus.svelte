<script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js">
    import {Container, Col, Row, Button, Card, CardBody, Form, FormGroup, FormText, Icon, 
    Input, Label, ListGroup, ListGroupItem, Collapse,CardHeader,CardSubtitle,
    CardText,CardTitle, Table } from 'sveltestrap';
    import Datepicker from 'svelte-calendar';

    let tree = [];
    let fileList = [];
    let hostUrl = "http://localhost:7000";
    let fileContent = "";
    let fileTitle = "";

    const logPaths = [
        "91_NextCMS_Log",
        "com",
        "oper01",
        "oper02",
        "pms",
        "spring-boot"
    ];

    const columns = ["FileName", "Process", "CreationTime"];

    const dummyData = [
        ["test1", "process1", new Date().toString()],
        ["test1", "process2", new Date().toString()],
        ["test1", "process3", new Date().toString()],
    ];

    const clickLogPath = (event) => {
       const groupList = document.querySelectorAll("item");

        let index = 0, length = groupList.length;
        for ( index; index < length; index++) {
            groupList[index].classList.remove("active");
        }

        event.target.classList.add("active");

        //callFolderTree();
    }

    const callFolderTree = (itemPath, isParent) => {

        let path = itemPath ? itemPath : "/Users/dream/test/";

        callFileList(itemPath);

        fetch(`${hostUrl}/file/tree?path=${path}`).then((response) => {
                console.log(response);

                response.text().then(function(text) {
                    console.log(text);

                    console.log("Success:", );

                    tree = JSON.parse(text);
                });
            }
        );
    }

    const callFileList = (itemPath) => {
        fetch(`${hostUrl}/file/lists?path=${itemPath}`).then((response) => {
                console.log(response);

                response.text().then(function(text) {
                    console.log(text);

                    fileList = JSON.parse(text);
                });
            }
        );
    }

    const callOpenFile = (filePath, fileName) => {
        fetch(`${hostUrl}/file/open?filePath=${filePath}`).then((response) => {
                console.log(response);

                response.text().then(function(text) {
                    fileTitle = fileName;
                    fileContent = text;
                });
            }
        );
    }

    let isOpen = false;

</script>

<Container>
    <Row class='mt-3'>
        <Col>
            <div class="shadow mb-3 bg-white rounded">
                <Card body class="pb-0">
                    <FormGroup row>
                        <Col sm='6'>
                            <Row class='mt-3'>
                                <Col sm='2' md={{offset:1}}>
                                    <Label for='server'>
                                        <div class='label'>
                                            서버
                                        </div>
                                    </Label>
                                </Col>  
                                <Col sm='10' md={{size: 8}} class='pl-0'>  
                                    <Input type='select' name='server' id='serverSelect'>  
                                        <option value = "">서버를 선택하세요</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                    </Input>
                                </Col>
                            </Row>
                        </Col>
                        <Col sm='6'>
                            <Row class='mt-3'>
                                <Col sm='2' md={{offset:1}}>
                                    <Label for='user'><div class='label'>사용자</div></Label>
                                </Col>  
                                <Col sm='10' md={{size: 8}} class='pl-0'>
                                    <Input 
                                        type='text'
                                        name='user'
                                        id='user'
                                    />    
                                </Col>
                            </Row>
                        </Col>
                    </FormGroup>
                </Card>
            </div> 
        </Col>
    </Row>
    <Row class='mt-2'>
        <Col sm='4'>
            <div class="shadow mb-2 bg-white rounded">
                <Card body>
                    <Label for='list' class='m-auto'><div class='label'>로그 관리 항목</div></Label>
                    <hr/>
                    <div class='cardBody'>
                        <ListGroup class='list'>
                        {#each logPaths as log, index}
                            {#if index == 0}
                                <ListGroupItem tag="button" action active>{log}</ListGroupItem>
                            {/if}
                            <ListGroupItem tag="button" action>{log}</ListGroupItem>
                        {/each}
                    </ListGroup>
                    </div>
                </Card>
            </div>
        </Col>
        <Col sm='4' class='pl-0'>
            <div class="shadow mb-2 bg-white rounded">
                <Card body>
                    <Label for='list' class='m-auto'><div class='label'>로그 일자</div></Label>
                    <hr/>
                    <div class='cardBody'>
                        <Datepicker/>
                    </div>
                </Card>
            </div>
        </Col>
        <Col sm='4' class='pl-0'>
            <div class="shadow mb-2 bg-white rounded">
                <Card body>
                    <Label for='list' class='m-auto'><div class='label'>검색 조건</div></Label>
                    <hr/>
                    <div class='cardBody'>    
                        <Row class='mb-2'>
                            <Col sm='3' class='pr-0'>
                                <div class='title'>수정 시간</div>  
                            </Col>
                            <Col sm='4' class='p-0'>
                                <Input 
                                    type='time' 
                                    name='from' 
                                    id='from' 
                                    placeholder='time placeholder' 
                                />
                            </Col>
                            <div>&nbsp;~&nbsp;</div>
                            <Col sm='4'class='p-0'>
                                <Input
                                    type='time' 
                                    name='from' 
                                    id='from' 
                                    placeholder='time placeholder'
                                />
                            </Col>
                        </Row>
                        <Row class='mb-2'>
                            <Col sm='3' class='pr-0'>
                                <div class='title'>검색 조건</div>  
                            </Col>
                            <Col sm='9' class='pl-0'>
                                <Input 
                                    type='text'
                                    name='keyword'
                                    id='keyword'
                                />    
                            </Col>
                        </Row>
                        <div class='btn btn-outline-info' on:click={() => (isOpen = !isOpen)}>
                            검색
                        </div>
                    </div>
                </Card>
            <div>
        </Col>
    </Row>
    <br>
    <Table hover>
        <thead>
            <tr>
                <th>#</th>
                {#each columns as column}
                    <th>{column}</th>
                {/each}
            </tr>
        </thead>
        <tbody>
            {#each dummyData as row, index}
            <tr>
                <th scope="row">{index+1}</th>
                {#each row as cell}
                <td>{cell}</td>
                {/each}
            </tr>
	    {/each}
        </tbody>
    </Table>
    
    <Collapse {isOpen}>
        <Card>
        <CardHeader>
            <Label for='content'><div class='content'>CMS Log Content</div></Label>
        </CardHeader>
        <CardBody>
            <CardText>
                    Some quick example text to build on the card title and make up the bulk of the card's content.
            </CardText>
        </CardBody>
    </Card>
    </Collapse>
</Container>

<style>
    .label {
        font-weight: bold;
        color: #777;
    }

    .cardBody {
        height: 22vh !important;
    }

    .title {
        font-weight: bold;
        color: #777;
        text-align: left;
        margin-bottom: 8px;
    }

    .content {
        padding-top: 5px;
        font-weight: bold;
        font-size: large;
        color: #777;
        text-align: left;
    }

</style>
