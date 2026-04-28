/* @Author Unknown user */
public float resolution = 4f;
@AutoWired
private ModelRenderer mr;

private Vector3 ls = new Vector3(-9999);
private float lr;

void start() {}

void repeat() {
  execute();
}

void stoppedRepeat() {
  execute();
} 

void execute() {
  boolean changes = false;
  Vector3 sca = myObject.globalScale;
  if (!sca.equals(ls)) changes = true;
  if(lr != resolution) changes = true;

  if (changes) {
    ls = sca.copy();
    lr = resolution;
    apply();
  }
}

void apply() {
  float r = ls.length();
  r = r * resolution;
  int ir = (int)Math.ceil(r);
  
  Vertex vertex = Math.createSubdividedPlane(ir);
  if(mr == null) mr = myObject.findComponent(ModelRenderer.class);
  mr.setVertex(vertex);
  mr.setDrawWireframeGizmo(false);
}