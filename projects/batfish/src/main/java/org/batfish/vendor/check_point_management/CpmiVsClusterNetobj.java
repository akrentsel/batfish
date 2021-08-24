package org.batfish.vendor.check_point_management;

import static com.google.common.base.Preconditions.checkArgument;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.annotations.VisibleForTesting;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.batfish.datamodel.Ip;

/** Data model for an object of type {@code CpmiClusterNetobj}. */
public final class CpmiVsClusterNetobj extends Cluster {

  @JsonCreator
  private static @Nonnull CpmiVsClusterNetobj create(
      @JsonProperty(PROP_CLUSTER_MEMBER_NAMES) @Nullable List<String> clusterMemberNames,
      @JsonProperty(PROP_IPV4_ADDRESS) @Nullable Ip ipv4Address,
      @JsonProperty(PROP_NAME) @Nullable String name,
      @JsonProperty(PROP_UID) @Nullable Uid uid) {
    checkArgument(clusterMemberNames != null, "Missing %s", PROP_CLUSTER_MEMBER_NAMES);
    checkArgument(ipv4Address != null, "Missing %s", PROP_IPV4_ADDRESS);
    checkArgument(name != null, "Missing %s", PROP_NAME);
    checkArgument(uid != null, "Missing %s", PROP_UID);
    return new CpmiVsClusterNetobj(clusterMemberNames, ipv4Address, name, uid);
  }

  @VisibleForTesting
  CpmiVsClusterNetobj(List<String> clusterMemberNames, Ip ipv4Address, String name, Uid uid) {
    super(clusterMemberNames, ipv4Address, name, uid);
  }

  @Override
  public boolean equals(Object obj) {
    return baseEquals(obj);
  }

  @Override
  public int hashCode() {
    return baseHashcode();
  }

  @Override
  public String toString() {
    return baseToStringHelper().toString();
  }
}